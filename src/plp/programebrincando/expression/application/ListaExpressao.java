package plp.programebrincando.expression.application;

import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.Lista;

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