package plp.programebrincando.expression.unary.action;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.unary.ExpressaoUnaria;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoExpressao;

public abstract class Action extends ExpressaoUnaria {

	public Action(Expressao expressao, String operador) {
		super(expressao, operador);
	}
	
	@Override
	public String toString() {
		return operador.toString() + " " + expressao.toString();
	}
	
	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoExpressao.ACTION;
	}

}