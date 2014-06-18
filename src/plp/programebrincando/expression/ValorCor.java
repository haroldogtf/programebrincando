package plp.programebrincando.expression;

public class ValorCor implements Valor {

	public int red;
	public int green;
	public int blue;
	
	public ValorCor(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "ValorCor(R: " +red + " G: " +green + "B: "+blue +")";
	}
}