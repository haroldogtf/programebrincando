package plp.programebrincando.command.declaration;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
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
	public AmbienteExecucao elabora(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		try {
			//TODO Ver qual método está lançando o erro. 
			ambiente.map(getId(), getExpressao().avaliar(ambiente));
		} catch (VariavelJaDeclaradaException | VariavelNaoDeclaradaException e) {
			e.printStackTrace();
		}
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		boolean result = false;
		try {
			result = getExpressao().checaTipo(ambiente);
			if (result) {
				ambiente.map(getId(), getExpressao().getTipo(ambiente));
			}
		} catch (VariavelNaoDeclaradaException e) {
			System.out.println("Variável já declarada. Nome: " + getId());
			e.printStackTrace();
		} catch (VariavelJaDeclaradaException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Id getId() {
		return id;
	}

	public Expressao getExpressao() {
		return expressao;
	}
}