package plp.programebrincando.command;

import plp.programebrincando.command.declaration.DefinicaoProcedimento;
import plp.programebrincando.command.declaration.ListaDeclaracaoProcedimentoParametro;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.ProcedimentoNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.ListaValor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class Aplicacao implements Comando {
	
	public Id id;
	public ListaExpressao lista;
	
	public Aplicacao(Id id, ListaExpressao lista) {
		this.id = id;
		this.lista = lista;
	}
	
	@Override
	public String toString() {
		return "DESENHE " +id.toString() + "(" + lista.toString() + ")";
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorNaoDeclaradoException, IdentificadorJaDeclaradoException{
		
		AmbienteExecucao ambienteAux = null;
		DefinicaoProcedimento procedimento;
		try {
			procedimento = ambiente.getProcedimento(id);
			ambiente.incrementa();
			
			ListaDeclaracaoProcedimentoParametro parametros = procedimento.getParametrosFormais();
			ambienteAux = bindParameters(ambiente, parametros);
			ambienteAux = procedimento.getComando().executar(ambienteAux);
			ambienteAux.restaura();
		} catch (ProcedimentoNaoDeclaradoException e) {
			e.printStackTrace();
			throw new IdentificadorJaDeclaradoException();
		} catch (VariavelNaoDeclaradaException e) {
			e.printStackTrace();
		} catch (VariavelJaDeclaradaException e) {
			e.printStackTrace();
		}
		return ambienteAux;
	}
	
	private AmbienteExecucao bindParameters(AmbienteExecucao ambiente, ListaDeclaracaoProcedimentoParametro parametros) 
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException{
		ListaValor listaValor = lista.avaliar(ambiente);
		while (listaValor.length() > 0) {
			ambiente.map(parametros.getHead().getId(), listaValor.getHead());
			parametros = (ListaDeclaracaoProcedimentoParametro) parametros.getTail();
			listaValor = (ListaValor) listaValor.getTail();
		}
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException {
		// TODO Auto-generated method stub
		return false;
	}
}