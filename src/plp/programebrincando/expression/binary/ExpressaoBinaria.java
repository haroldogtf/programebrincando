package plp.programebrincando.expression.binary;

import java.util.Map;

import plp.programebrincando.command.declaration.DeclaracaoParametro;
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
	public Expressao redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map){
		//TODO Verificar como fazer o expressao binaria
		expressaoEsquerda = expressaoEsquerda.redefinirParametro(map);
		expressaoDireita = expressaoDireita.redefinirParametro(map);
		return this;
	}
	
	@Override
	public String toString() {
		return expressaoEsquerda.toString() + " " + operador + " " + expressaoDireita.toString();
	}
}