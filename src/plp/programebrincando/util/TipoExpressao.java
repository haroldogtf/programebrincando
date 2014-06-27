package plp.programebrincando.util;

public enum TipoExpressao implements Tipo {

	BOOLEAN("BOOLEAN"),
	COR("COLOR"),
	INTEGER("INTEGER"),
	ACTION("ACTION"),
	IFTHENELSE("IFTHENELSE"),
	FOR("FOR"),
	LEARN("LEARN"),
	ASSIGN("ASSIGN"),
	SEQUENCE("SEQUENCE");
	
	private String nome;

	private TipoExpressao(String nome) {
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
	public boolean isAction() {
		return this.isEqual(ACTION);
	}
	
	@Override
	public boolean isColor() {
		return this.isEqual(COR);
	}
	
	@Override
	public boolean isSequence(){
		return this.isEqual(SEQUENCE);
	}
	
	@Override
	public boolean isIfThenElse(){
		return this.isEqual(IFTHENELSE);
	}
	
	@Override
	public boolean isFor(){
		return this.isEqual(FOR);
	}
	
	@Override
	public boolean isLearn(){
		return this.isEqual(LEARN);
	}
	
	@Override
	public boolean isAssign(){
		return this.isEqual(ASSIGN);
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

}