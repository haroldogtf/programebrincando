package plp.programebrincando.expression.declaration;

import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;

public class Declaracao implements Expressao {

	public Id id;
	public ListaDeclaracaoParametro lista;
	public Expressao expressao;
	
	public Declaracao(Id id, ListaDeclaracaoParametro lista, Expressao expressao) {
		this.id = id;
		this.lista = lista;
		this.expressao = expressao;
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "APRENDA " + id.toString() + " (" + lista.toString() + ") " + expressao.toString() + " FIMAPRENDA";
	}

}