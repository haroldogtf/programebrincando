package plp.programebrincando.expression;

public class ValorInteiro implements Valor{

	public int valor;
	
	public ValorInteiro(int valor){
		this.valor = valor;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}