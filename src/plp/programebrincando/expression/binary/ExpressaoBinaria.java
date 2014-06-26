package plp.programebrincando.expression.binary;

import plp.programebrincando.expression.Expressao;

public abstract class ExpressaoBinaria implements Expressao {

	public Expressao expressaoEsquerda;
	public Expressao expressaoDireita;
	public String operador;
	
	public ExpressaoBinaria(Expressao expressaoEsquerda, Expressao expressaoDireita, String operator) {
		this.expressaoEsquerda = expressaoEsquerda;
		this.expressaoDireita = expressaoDireita;
		this.operador = operator;
	}
	
	@Override
	public String toString() {
		return expressaoEsquerda.toString() + " " + operador + " " + expressaoDireita.toString();
	}

}