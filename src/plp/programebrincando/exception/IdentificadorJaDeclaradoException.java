package plp.programebrincando.exception;

public class IdentificadorJaDeclaradoException extends Exception {

	private static final long serialVersionUID = 7850877979764942022L;

	public IdentificadorJaDeclaradoException(){
		super();
	}
	
	public IdentificadorJaDeclaradoException(String msg){
		super(msg);
	}
}