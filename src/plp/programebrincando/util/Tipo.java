package plp.programebrincando.util;

public interface Tipo {

	String getName();

	boolean isBoolean();
	boolean isColor();
	boolean isInteger();
	boolean isParametro();
	boolean isProcedimento();

	boolean isEqual(Tipo tipo);
	boolean isValid();
}