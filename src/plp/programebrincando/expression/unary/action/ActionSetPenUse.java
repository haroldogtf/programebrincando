package plp.programebrincando.expression.unary.action;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class ActionSetPenUse extends Action {

	private static final String operador = "USARCANETA";

	public ActionSetPenUse(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public Valor avaliar(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorBooleano usarCaneta = (ValorBooleano) expressao.avaliar(ambiente);
		ambiente.setPenUse(usarCaneta.valor());

		System.out.println("Usar Caneta: " + ambiente.getPenUse());
		return new ValorBooleano(true);
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (this.getExpressao().getTipo(amb).isBoolean());
	}
}