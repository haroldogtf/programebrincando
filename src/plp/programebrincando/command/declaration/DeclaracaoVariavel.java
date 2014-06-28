package plp.programebrincando.command.declaration;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class DeclaracaoVariavel implements Declaracao {

	private Id id;
	private Expressao expressao;

	public DeclaracaoVariavel(Id id, Expressao expressao) {
		this.id = id;
		this.expressao = expressao;
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		ambiente.map(getId(), getExpressao().avaliar(ambiente));
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		boolean result = expressao.checaTipo(ambiente);
		if (result) {
			ambiente.map(id, expressao.getTipo(ambiente));
		}
		return result;
	}

	public Id getId() {
		return id;
	}

	public Expressao getExpressao() {
		return expressao;
	}
	
	@Override
	public String toString() {
		return "VAR " + id + " = " + expressao;
	}
}