package plp.programebrincando.exception;

import plp.programebrincando.expression.Id;

public class ProcedimentoNaoDeclaradoException extends Exception {
	
	private static final long serialVersionUID = -6407323127369054315L;
	
	public ProcedimentoNaoDeclaradoException() {
		super();
	}
	
	public ProcedimentoNaoDeclaradoException(Id id) {
		super("Procedimento " + id + " não declarado.");
	}
}