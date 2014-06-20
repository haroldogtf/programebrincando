package plp.programebrincando.expression;

public class ListaExpressao extends Lista<Expressao> {

	public Id head;
	public ListaExpressao tail;

	public ListaExpressao() {

	}

	public ListaExpressao(Expressao expressao) {
		super(expressao, new ListaExpressao());
	}

	public ListaExpressao(Expressao expressao, ListaExpressao listaExpressao) {
		super(expressao, listaExpressao);
	}
}