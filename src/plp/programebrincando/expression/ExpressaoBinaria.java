package plp.programebrincando.expression;

public abstract class ExpressaoBinaria implements Expressao{

	public Expressao expressaoEsquerda;
	public Expressao expressaoDireita;
	public String operador;
	
	public ExpressaoBinaria(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		this.expressaoEsquerda = expressaoEsquerda;
		this.expressaoDireita = expressaoDireita;
	}
	
	@Override
	public String toString() {
		return expressaoEsquerda.toString() + " " + operador + " " + expressaoDireita.toString();
	}
}