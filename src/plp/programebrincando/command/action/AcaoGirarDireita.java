package plp.programebrincando.command.action;

import plp.programebrincando.arduino.ArduinoGenerator;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.graphical.GraphicalGenerator;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.move.AlgoritmoGirar;

public class AcaoGirarDireita extends Acao {

	private static final String operador = "GIRARDIREITA";
	
	public AcaoGirarDireita(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		
		ValorInteiro degrees = (ValorInteiro) super.getExpressao().avaliar(ambiente);
		Integer newDegreesValue = AlgoritmoGirar.girar(this, ambiente, degrees.valor());
		System.out.println("Current Degrees: " + ambiente.getDegrees() + ". New Degree: " + newDegreesValue);
		ambiente.setDegrees(newDegreesValue);
		
		GraphicalGenerator.pintar(ambiente);
		ArduinoGenerator.girarDireita(degrees.valor());
		
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return this.getExpressao().getTipo(ambiente).isInteger() || this.getExpressao().getTipo(ambiente).isParametro();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new AcaoGirarDireita(super.getExpressao());
	}
}