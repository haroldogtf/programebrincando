package plp.programebrincando.util;

public interface Tipo {

	public abstract String getName();

	public abstract boolean isInteger();

	public abstract boolean isBoolean();

	public abstract boolean isString();

	public abstract boolean isEqual(Tipo tipo);

	public abstract boolean isValid();
	
	public abstract boolean isColor();

}