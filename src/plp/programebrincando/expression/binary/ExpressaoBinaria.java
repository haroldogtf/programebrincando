package plp.programebrincando.expression.binary;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;

//TODO Remover os métodos gerados nesta classe e adicinar em cada classe de expressão binária

public abstract class ExpressaoBinaria implements Expressao{

	public Expressao expressaoEsquerda;
	public Expressao expressaoDireita;
	public String operador;
	
	public ExpressaoBinaria(Expressao expressaoEsquerda, Expressao expressaoDireita, String operator) {
		this.expressaoEsquerda = expressaoEsquerda;
		this.expressaoDireita = expressaoDireita;
		this.operador = operator;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return expressaoEsquerda.toString() + " " + operador + " " + expressaoDireita.toString();
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