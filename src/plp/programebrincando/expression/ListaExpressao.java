package plp.programebrincando.expression;

public class ListaExpressao {

	public Id head;
	public ListaExpressao tail;

	public ListaExpressao() {
	}

	public ListaExpressao(Id id) {
		this.head = id;
	}

	public ListaExpressao(Id id, ListaExpressao listaExpressao) {
		this.head = id;
		this.tail = listaExpressao;
	}

}
