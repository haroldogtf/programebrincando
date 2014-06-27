package plp.programebrincando.exception;

public class IdentificadorNaoDeclaradoException extends Exception {

	private static final long serialVersionUID = -9021491451964954640L;
	
	public IdentificadorNaoDeclaradoException(String msg) {
		super(msg);
	}

	public IdentificadorNaoDeclaradoException() {
		super();
	}
}