package plp.programebrincando.expression.binary;

import plp.programebrincando.expression.Expressao;

public class ExpressaoMenorQue extends ExpressaoBinaria {

	public ExpressaoMenorQue(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "<");
	}

}
