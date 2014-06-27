package plp.programebrincando.exception;

import plp.programebrincando.expression.Id;

public class ProcedimentoJaDeclaradoException extends Exception {
	private static final long serialVersionUID = 2872443763887610498L;
	
	public ProcedimentoJaDeclaradoException() {
		super();
	}
	
	public ProcedimentoJaDeclaradoException(Id id) {
		super("Procedimento " + id + " já declarado.");
	}
}