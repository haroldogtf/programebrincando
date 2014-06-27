package plp.programebrincando.util;

public interface Tipo {

	String getName();

	boolean isInteger();

	boolean isBoolean();

	boolean isAction();
	
	boolean isColor();

	boolean isEqual(Tipo tipo);

	boolean isValid();

	boolean isLearn();

	boolean isFor();

	boolean isIfThenElse();

	boolean isSequence();

	boolean isAssign();
	
}