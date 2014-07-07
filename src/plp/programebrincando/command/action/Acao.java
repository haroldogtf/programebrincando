package plp.programebrincando.command.action;

import java.util.Map;

import plp.programebrincando.command.Comando;
import plp.programebrincando.command.declaration.DeclaracaoParametro;
import plp.programebrincando.expression.Expressao;

public abstract class Acao implements Comando {
	
	private Expressao expressao;
	private String operador;
	
	public Acao(Expressao expressao, String operador) {
		this.expressao = expressao;
		this.operador = operador;
	}
	
	@Override
	public Comando redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map){
		expressao = expressao.redefinirParametro(map);
		return this;
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