package plp.programebrincando;

import plp.programebrincando.expression.Expressao;

public class Programa {

	private Expressao expressao;
	
	public Programa(Expressao expressao){
		this.expressao = expressao;
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}
}