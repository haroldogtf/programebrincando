package plp.programebrincando.expression;

public class For implements Expressao {

	public Expressao expressaoLoop;
	public Expressao expressaoExecucao;

	public For(Expressao expressaoLoop, Expressao expressaoExecucao) {
		this.expressaoLoop = expressaoLoop;
		this.expressaoExecucao = expressaoExecucao;

		System.out.println(this);
	}

	@Override
	public String toString() {
		return "for " + expressaoLoop.toString() + ", " + expressaoExecucao.toString();	
	}
}