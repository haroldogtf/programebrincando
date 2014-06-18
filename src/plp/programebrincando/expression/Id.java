package plp.programebrincando.expression;

public class Id implements Expressao {

	public String idName;
	
	public Id(String idName) {
		this.idName = idName;
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return idName;
	}
}