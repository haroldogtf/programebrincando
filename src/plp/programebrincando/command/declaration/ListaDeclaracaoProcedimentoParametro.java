package plp.programebrincando.command.declaration;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Lista;
import plp.programebrincando.memory.AmbienteCompilacao;

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
	
	public AmbienteCompilacao elabora(AmbienteCompilacao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		AmbienteCompilacao resposta;
		if (getHead() != null) {
			if (getTail() != null) {
				resposta = ((ListaDeclaracaoProcedimentoParametro) getTail()).elabora(getHead().elabora(ambiente));
			} else {
				resposta = getHead().elabora(ambiente);
			}
		} else {
			resposta = ambiente;
		}
		return resposta;
	}
}