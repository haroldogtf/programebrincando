package plp.programebrincando.expression.binary;

import plp.programebrincando.expression.Expressao;

public class ExpressaoIgual extends ExpressaoBinaria {

	public ExpressaoIgual(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "==");
	}

}