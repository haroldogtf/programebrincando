package plp.programebrincando.command.declaration;

import java.util.Map;

import plp.programebrincando.command.Comando;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.ProcedimentoJaDeclaradoException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.memory.ContextoCompilacao;
import plp.programebrincando.util.TipoExpressaoComando;

public class DeclaracaoProcedimento implements Declaracao {

	protected Id id;
	protected DefinicaoProcedimento definicaoProcedimento;
	
	public DeclaracaoProcedimento() {
	}
	
	public DeclaracaoProcedimento(Id id, DefinicaoProcedimento definicaoProcedimento) {
		this.id = id;
		this.definicaoProcedimento = definicaoProcedimento;
	}
	
	@Override
	public String toString() {
		return "APRENDA " + id.toString() + definicaoProcedimento.toString() + " FIMAPRENDA";
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		try {
			ambiente.mapProcedimento(id, definicaoProcedimento);
		} catch (ProcedimentoJaDeclaradoException e) {
			e.printStackTrace();
		}
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		ListaDeclaracaoProcedimentoParametro parametros = definicaoProcedimento.getParametros();
		
		ambiente.incrementa();
		ambiente = parametros.elabora(ambiente);

		boolean valido = definicaoProcedimento.getComando().checaTipo(ambiente);
		ambiente.restaura();
		
		ambiente.map(id, TipoExpressaoComando.PROCEDIMENTO);
		
		return valido;
	}

	@Override
	public Comando redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map) {
		return this;
	}
}