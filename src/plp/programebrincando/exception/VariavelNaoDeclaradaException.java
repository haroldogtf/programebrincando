package plp.programebrincando.exception;

import plp.programebrincando.expression.Id;

public class VariavelNaoDeclaradaException extends IdentificadorNaoDeclaradoException {

	private static final long serialVersionUID = 674916079149361339L;

	public VariavelNaoDeclaradaException(Id id) {
		super("Variável " + id + " não declarada.");
	}
}