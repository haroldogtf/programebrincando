package plp.programebrincando.expression;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "+");
	}
}