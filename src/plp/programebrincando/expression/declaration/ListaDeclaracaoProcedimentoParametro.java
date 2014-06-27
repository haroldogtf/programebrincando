package plp.programebrincando.expression.declaration;

import plp.programebrincando.expression.Lista;


public class ListaDeclaracaoProcedimentoParametro extends Lista<DeclaracaoParametro> {

	public ListaDeclaracaoProcedimentoParametro() {
	}

	public ListaDeclaracaoProcedimentoParametro(DeclaracaoParametro declaracao) {
		super(declaracao, null);
	}

	public ListaDeclaracaoProcedimentoParametro(DeclaracaoParametro declaracao,
			ListaDeclaracaoProcedimentoParametro listaDeclaracao) {
		super(declaracao, listaDeclaracao);
	}
}