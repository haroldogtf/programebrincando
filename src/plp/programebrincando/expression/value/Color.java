package plp.programebrincando.expression.value;

public class Color {

	public int red;
	public int green;
	public int blue;
	
	public Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	@Override
	public String toString() {
		return "Cor(" + red + ", " + green + ", " + blue + ")"; 
	}
}