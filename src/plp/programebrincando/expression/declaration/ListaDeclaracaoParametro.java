package plp.programebrincando.expression.declaration;

import plp.programebrincando.expression.Lista;


public class ListaDeclaracaoParametro extends Lista<DeclaracaoParametro> {

	public ListaDeclaracaoParametro() {
	}

	public ListaDeclaracaoParametro(DeclaracaoParametro declaracao) {
		super(declaracao, null);
	}

	public ListaDeclaracaoParametro(DeclaracaoParametro declaracao,
			ListaDeclaracaoParametro listaDeclaracao) {
		super(declaracao, listaDeclaracao);
	}
}