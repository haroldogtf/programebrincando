package plp.programebrincando.command.declaration;

import plp.programebrincando.command.Comando;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class DeclaracaoProcedimento implements Comando {

	private Id id;
	private DefinicaoProcedimento definicaoProcedimento;
	
	public DeclaracaoProcedimento(Id id, DefinicaoProcedimento definicaoProcedimento) {
		this.id = id;
		this.definicaoProcedimento = definicaoProcedimento;
	}
	
	@Override
	public String toString() {
		return "APRENDA " + id.toString() + definicaoProcedimento.toString() + " FIMAPRENDA";
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		boolean resposta;

		//TODO Verificar o getTipo da definição de procedimento
//		ambiente.map(id, definicaoProcedimento.getTipo());

		ListaDeclaracaoProcedimentoParametro parametrosFormais = definicaoProcedimento.getParametrosFormais();
		ambiente.incrementa();
		ambiente = parametrosFormais.elabora(ambiente);
		resposta = definicaoProcedimento.getComando().checaTipo(ambiente);
		ambiente.restaura();
		return resposta;
	}
}