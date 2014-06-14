package plp.programebrincando.expression;

public class Declaracao implements Expressao {

	public Id id;
	public ListaParametros lista;
	public Expressao expressao;
	
	public Declaracao(Id id, ListaParametros lista, Expressao expressao) {
		this.id = id;
		this.lista = lista;
		this.expressao = expressao;
	}
	
	@Override
	public String toString() {
		return "APRENDA " + id + lista.toString() + expressao.toString() + " FIMAPRENDA";
	}
}