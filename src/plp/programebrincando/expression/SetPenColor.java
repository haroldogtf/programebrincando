package plp.programebrincando.expression;

public class SetPenColor extends Acao {

	public Valor valor;
	
	public SetPenColor(Valor valor){
		this.valor = valor;
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return ((ValorCor)valor).red + " " + ((ValorCor)valor).green + " " + ((ValorCor)valor).blue;
	}
}