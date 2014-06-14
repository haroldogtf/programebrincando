package plp.programebrincando.expression;

public class ExpressaoIgual extends ExpressaoBinaria {

	public ExpressaoIgual(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita);
		this.operador = "==";
	}
}