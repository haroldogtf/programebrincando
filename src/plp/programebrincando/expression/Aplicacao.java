package plp.programebrincando.expression;

public class Aplicacao implements Expressao {
	
	public Id id;
	public ListaExpressao lista;
	
	public Aplicacao(Id id, ListaExpressao lista) {
		this.id = id;
		this.lista = lista;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "DESENHE " +id.toString() + "(" + lista.toString() + ")";
	}

}
