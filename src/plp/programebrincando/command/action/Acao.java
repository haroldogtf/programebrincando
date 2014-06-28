package plp.programebrincando.command.action;

import plp.programebrincando.command.Comando;
import plp.programebrincando.expression.Expressao;

public abstract class Acao implements Comando {
	
	private Expressao expressao;
	private String operador;
	
	public Acao(Expressao expressao, String operador) {
		this.expressao = expressao;
		this.operador = operador;
	}
	
	@Override
	public String toString() {
		return operador.toString() + " " + expressao.toString();
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public String getOperador() {
		return operador;
	}
}