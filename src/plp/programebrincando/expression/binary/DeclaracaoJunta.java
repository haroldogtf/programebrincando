package plp.programebrincando.expression.binary;

import java.util.HashMap;
import java.util.Map;

import plp.programebrincando.command.Comando;
import plp.programebrincando.command.SequenciaComando;
import plp.programebrincando.command.declaration.DeclaracaoParametro;
import plp.programebrincando.command.declaration.DeclaracaoProcedimento;
import plp.programebrincando.command.declaration.DefinicaoProcedimento;
import plp.programebrincando.command.declaration.ListaDeclaracaoProcedimentoParametro;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.ProcedimentoJaDeclaradoException;
import plp.programebrincando.exception.ProcedimentoNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.Lista;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.TipoExpressaoComando;

public class DeclaracaoJunta extends DeclaracaoProcedimento {
	private static final String CARACTER_REDEFINICAO = "_";
	private Map<DeclaracaoParametro, DeclaracaoParametro> mapRedefinicao = new HashMap<DeclaracaoParametro, DeclaracaoParametro>();
	
	private Expressao aprenda1;
	private Expressao aprenda2;
	
	public DeclaracaoJunta(Id id, Expressao aprenda1, Expressao aprenda2) {
		this.id = id;
		this.aprenda1 = aprenda1;
		this.aprenda2 = aprenda2;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return aprenda1.checaTipo(ambiente) && aprenda1.getTipo(ambiente).equals(TipoExpressaoComando.PROCEDIMENTO) &&
				aprenda2.checaTipo(ambiente) && aprenda2.getTipo(ambiente).equals(TipoExpressaoComando.PROCEDIMENTO);
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		try {
			ListaDeclaracaoProcedimentoParametro parametros = inicializarParametros(ambiente);
			Comando comando = inicializarComandos(ambiente);
			definicaoProcedimento = new DefinicaoProcedimento(parametros, comando);
			ambiente.mapProcedimento(id, definicaoProcedimento);
		} catch (ProcedimentoJaDeclaradoException | ProcedimentoNaoDeclaradoException e) {
			e.printStackTrace();
		}
		return ambiente;
	}
	
	private Comando inicializarComandos(AmbienteExecucao ambiente) throws ProcedimentoNaoDeclaradoException{
		DefinicaoProcedimento definicaoProcedimento1 = ambiente.getProcedimento((Id) aprenda1);
		Comando comando1 = definicaoProcedimento1.getComando();

		DefinicaoProcedimento definicaoProcedimento2 = ambiente.getProcedimento((Id) aprenda2);
		Comando comando2 = definicaoProcedimento2.getComando();
		Comando comandoRedefinido = comando2.redefinirParametro(mapRedefinicao);
		
		return new SequenciaComando(comando1, comandoRedefinido);
	}
	
	private ListaDeclaracaoProcedimentoParametro inicializarParametros(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, ProcedimentoNaoDeclaradoException{
		ListaDeclaracaoProcedimentoParametro lista = new ListaDeclaracaoProcedimentoParametro();
		
		//Parametros 1
		DefinicaoProcedimento definicaoProcedimento1 = ambiente.getProcedimento((Id) aprenda1);
		ListaDeclaracaoProcedimentoParametro parametros1 = definicaoProcedimento1.getParametros();
		
		DeclaracaoParametro head1 = parametros1.getHead();
		Lista<DeclaracaoParametro> tail1 = parametros1.getTail();
		
		//Parametros 2
		DefinicaoProcedimento definicaoProcedimento2 = ambiente.getProcedimento((Id) aprenda2);
		ListaDeclaracaoProcedimentoParametro parametros2 = definicaoProcedimento2.getParametros();
		
		DeclaracaoParametro head2 = parametros2.getHead();
		Lista<DeclaracaoParametro> tail2 = parametros2.getTail();

		if(head1 != null){
			lista = new ListaDeclaracaoProcedimentoParametro(head1);
		}else if(head2 != null){
			lista = new ListaDeclaracaoProcedimentoParametro(head2);
		}

		while (tail1 != null && tail1.getHead() != null) {
			DeclaracaoParametro declaracaoParametro = tail1.getHead();
			lista = new ListaDeclaracaoProcedimentoParametro(declaracaoParametro, lista);
			tail1 = tail1.getTail();
		}

		if(head1 != null && head2 != null){
			if(parametroJaDeclarado(lista, head2)){
				String idName = head2.getId().getIdName();
				idName = CARACTER_REDEFINICAO + idName;
				
				DeclaracaoParametro head2Redefinido = new DeclaracaoParametro(new Id(idName)); 
				mapRedefinicao.put(head2, head2Redefinido);
			
				lista = new ListaDeclaracaoProcedimentoParametro(head2Redefinido, lista);
			}else{
				lista = new ListaDeclaracaoProcedimentoParametro(head2, lista);
			}
		}
		
		while (tail2 != null && tail2.getHead() != null) {
			DeclaracaoParametro declaracaoParametro = tail2.getHead();
			
			if(parametroJaDeclarado(lista, declaracaoParametro)){
				String idName = declaracaoParametro.getId().getIdName();
				idName = CARACTER_REDEFINICAO + idName;
				
				DeclaracaoParametro declaracaoParametroRedefinido = new DeclaracaoParametro(new Id(idName)); 
				mapRedefinicao.put(declaracaoParametro, declaracaoParametroRedefinido);
				
				lista = new ListaDeclaracaoProcedimentoParametro(new DeclaracaoParametro(new Id(idName)), lista);
			}else{
				lista = new ListaDeclaracaoProcedimentoParametro(declaracaoParametro, lista);
			}
			tail2 = tail2.getTail();
		}
		return lista;
	}
	
	private boolean parametroJaDeclarado(ListaDeclaracaoProcedimentoParametro lista, DeclaracaoParametro declaracaoParametro){
		boolean declarado = false;
		
		while(lista != null && lista.getHead() != null){
			if(lista.getHead().equals(declaracaoParametro)){
				declarado = true;
				break;
			}else{
				lista = (ListaDeclaracaoProcedimentoParametro) lista.getTail();
			}
		}
		return declarado;
	}
}