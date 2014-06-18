package plp.programebrincando.expression;

public class ExpressaoMenorQue extends ExpressaoBinaria {

	public ExpressaoMenorQue(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "<");
	}

}
