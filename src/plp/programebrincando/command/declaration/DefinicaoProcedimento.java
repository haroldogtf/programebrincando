package plp.programebrincando.command.declaration;

import plp.programebrincando.command.Comando;

public class DefinicaoProcedimento {

	private ListaDeclaracaoProcedimentoParametro parametros;
	private Comando comando;

	public DefinicaoProcedimento(ListaDeclaracaoProcedimentoParametro parametros, Comando comando) {
		this.parametros = parametros;
		this.comando = comando;
	}

	public Comando getComando() {
		return comando;
	}

	public ListaDeclaracaoProcedimentoParametro getParametros() {
		return parametros;
	}
	
	@Override
	public String toString() {
		String retorno = " ";
		if(parametros.getHead() == null){
			retorno += "() ";
		}else{
			retorno += "(" + parametros.toString() + ") ";
		}
		return retorno + comando.toString();
	}
}
