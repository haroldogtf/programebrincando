package plp.programebrincando.expression;

public class IfThenElse implements Expressao {

	public Expressao expressao;
	public Expressao expressaoThen;
	public Expressao expressaoElse;
	
	public IfThenElse(Expressao expressao, Expressao expressaoThen, Expressao expressaoElse) {
		this.expressao = expressao;
		this.expressaoThen = expressaoThen;
		this.expressaoElse = expressaoElse;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "if(" + expressao.toString() + ")" + " then " + expressaoThen.toString() + " else " + expressaoElse.toString();
	}
}