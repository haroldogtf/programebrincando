package plp.programebrincando.util;

public enum TipoExpressaoComando implements Tipo {

	BOOLEAN("BOOLEAN"),
	COR("COLOR"),
	INTEGER("INTEGER"),
	PARAMETRO("PARAMETRO"),
	PROCEDIMENTO("PROCEDIMENTO");
	
	private String nome;

	private TipoExpressaoComando(String nome) {
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

	@Override
	public boolean isColor() {
		return this.isEqual(COR);
	}

	@Override
	public boolean isProcedimento(){
		return this.isEqual(PROCEDIMENTO);
	}
	
	@Override
	public boolean isParametro(){
		return this.isEqual(PARAMETRO);
	}
	
	@Override
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
}