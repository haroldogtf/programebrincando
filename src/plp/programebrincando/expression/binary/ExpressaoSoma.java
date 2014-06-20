package plp.programebrincando.expression.binary;

import plp.programebrincando.expression.Expressao;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "+");
	}
}