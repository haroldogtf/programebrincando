package plp.programebrincando.expression.binary;

import plp.programebrincando.expression.Expressao;

public class ExpressaoMenorIgualQue extends ExpressaoBinaria {

	public ExpressaoMenorIgualQue(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "<=");
	}

}
