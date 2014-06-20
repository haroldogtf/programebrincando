package plp.programebrincando.expression.value;

public class Cor {

	public int red;
	public int green;
	public int blue;
	
	public Cor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	@Override
	public String toString() {
		return "Cor(" + red + ", " + green + ", " + blue + ")"; 
	}
}