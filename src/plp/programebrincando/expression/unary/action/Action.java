package plp.programebrincando.expression.unary.action;

import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.unary.ExpressaoUnaria;

public abstract class Action extends ExpressaoUnaria {

	public Action(Expressao expressao, String operador) {
		super(expressao, operador);
	}
	
	@Override
	public String toString() {
		return operador.toString() + " " + expressao.toString();
	}
}