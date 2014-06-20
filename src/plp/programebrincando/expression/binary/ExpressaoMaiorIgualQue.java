package plp.programebrincando.expression.binary;

import plp.programebrincando.expression.Expressao;

public class ExpressaoMaiorIgualQue extends ExpressaoBinaria {

	public ExpressaoMaiorIgualQue(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, ">=");
	}

}
