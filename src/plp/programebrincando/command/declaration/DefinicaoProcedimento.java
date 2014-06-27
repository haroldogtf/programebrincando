package plp.programebrincando.command.declaration;

import plp.programebrincando.command.Comando;

public class DefinicaoProcedimento {

	private ListaDeclaracaoProcedimentoParametro parametrosFormais;
	private Comando comando;

	public DefinicaoProcedimento(ListaDeclaracaoProcedimentoParametro parametrosFormais, Comando comando) {
		this.parametrosFormais = parametrosFormais;
		this.comando = comando;
	}

	public Comando getComando() {
		return comando;
	}

	public ListaDeclaracaoProcedimentoParametro getParametrosFormais() {
		return parametrosFormais;
	}
}
