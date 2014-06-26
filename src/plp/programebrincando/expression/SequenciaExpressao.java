package plp.programebrincando.expression;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;

public class SequenciaExpressao implements Expressao{

	public Expressao expressao1;
	public Expressao expressao2;
	
	public SequenciaExpressao(Expressao expressao1, Expressao expressao2) {
		this.expressao1 = expressao1;
		this.expressao2 = expressao2;
	}
	
	@Override
	public String toString() {
		return expressao1.toString() + "; " + expressao2.toString();
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException { 
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}
}