package plp.programebrincando.expression.unary.action;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.AlgoritmoGirarUtil;

public class ActionLeft extends Action {

	private static final String operador = "GIRARESQUERDA";
	
	public ActionLeft(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorInteiro degrees = (ValorInteiro) expressao.avaliar(amb);
		Integer newDegreesValue = AlgoritmoGirarUtil.girar(this, amb, degrees.valor());
		System.out.println("Current Degrees: " + amb.getDegrees() + ". New Degree: " + newDegreesValue);
		amb.setDegrees(newDegreesValue);
		
		return new ValorBooleano(true);
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (this.getExpressao().getTipo(amb).isInteger());
	}
}