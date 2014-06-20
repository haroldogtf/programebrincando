package plp.programebrincando.util;

public enum TipoPrimitivo implements Tipo {

	BOOLEAN("BOOLEAN"),
	COR("COLOR"),
	INTEGER("INTEGER");

	private String nome;

	private TipoPrimitivo(String nome) {
		this.nome = nome;
	}
	
	public String getName() {
		return nome;
	}

	public boolean isInteger() {
		return this.isEqual(INTEGER);
	}

	public boolean isBoolean() {
		return this.isEqual(BOOLEAN);
	}

	public boolean isEqual(Tipo tipo) {
		boolean ret = false;
		if (isValid()) {
			if (tipo.isValid()) {
				ret = this.nome.equals(tipo.getName());
			} else {
				ret = tipo.isEqual(this);
			}
		}
		return ret;
	}

	public boolean isValid() {
		return this.nome != null && nome.length() > 0;
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public boolean isColor() {
		return this.isEqual(COR);
	}
}