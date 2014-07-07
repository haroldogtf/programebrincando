package plp.programebrincando.command.action;

import plp.programebrincando.arduino.ArduinoGenerator;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.graphical.GraphicalGenerator;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class AcaoUsarCaneta extends Acao {

	private static final String operador = "USARCANETA";

	public AcaoUsarCaneta(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		ValorBooleano usarCaneta = (ValorBooleano) super.getExpressao().avaliar(ambiente);
		ambiente.setPenUse(usarCaneta.valor());
		System.out.println("Usar Caneta: " + ambiente.getPenUse());
		
		GraphicalGenerator.pintar(ambiente);
		ArduinoGenerator.usarCaneta(usarCaneta.valor());
		
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return this.getExpressao().getTipo(ambiente).isBoolean() || this.getExpressao().getTipo(ambiente).isParametro();
	}
}