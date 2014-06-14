package plp.programebrincando.expression;

public class ValorInteiro implements Valor{

	public int valor;
	
	public ValorInteiro(int valor){
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}