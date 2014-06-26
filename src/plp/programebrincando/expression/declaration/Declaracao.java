package plp.programebrincando.expression.declaration;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;

public class Declaracao implements Expressao {

	public Id id;
	public ListaDeclaracaoParametro lista;
	public Expressao expressao;
	
	public Declaracao(Id id, ListaDeclaracaoParametro lista, Expressao expressao) {
		this.id = id;
		this.lista = lista;
		this.expressao = expressao;
	}
	
	@Override
	public String toString() {
		return "APRENDA " + id.toString() + " (" + lista.toString() + ") " + expressao.toString() + " FIMAPRENDA";
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

}