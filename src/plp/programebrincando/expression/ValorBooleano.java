package plp.programebrincando.expression;

public class ValorBooleano implements Valor{

	public boolean valor;
	
	public ValorBooleano(boolean valor) {
		this.valor = valor;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}