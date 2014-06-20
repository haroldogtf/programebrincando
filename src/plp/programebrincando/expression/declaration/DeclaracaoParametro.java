package plp.programebrincando.expression.declaration;

import plp.programebrincando.expression.Id;

public class DeclaracaoParametro {

	private Id id;

	public DeclaracaoParametro(Id id) {
		this.id = id;
	}

	public Id getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
}