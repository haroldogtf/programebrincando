package plp.programebrincando.expression;

public class SequenciaExpressao implements Expressao{

	public Expressao expressao1;
	public Expressao expressao2;
	
	public SequenciaExpressao(Expressao expressao1, Expressao expressao2) {
		this.expressao1 = expressao1;
		this.expressao2 = expressao2;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return expressao1.toString() + "; " + expressao2.toString();
	}
}