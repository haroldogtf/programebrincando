package plp.programebrincando.expression.unary;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.memory.AmbienteCompilacao;

public abstract class ExpressaoUnaria implements Expressao {
	
	protected Expressao expressao;

	protected String operador;

	public ExpressaoUnaria(Expressao expressao, String operador) {
		this.expressao = expressao;
		this.operador = operador;
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public String getOperador() {
		return operador;
	}

	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
		return getExpressao().checaTipo(amb) && this.checaTipoElementoTerminal(amb);
	}

	@Override
	public String toString() {
		return String.format("%s %s", operador, expressao);
	}

	protected abstract boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException;
}