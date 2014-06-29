package plp.programebrincando.command.action;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.move.AlgoritmoGirar;

public class AcaoGirarEsquerda extends Acao {

	private static final String operador = "GIRARESQUERDA";
	
	public AcaoGirarEsquerda(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		ValorInteiro degrees = (ValorInteiro) super.getExpressao().avaliar(ambiente);
		Integer newDegreesValue = AlgoritmoGirar.girar(this, ambiente, degrees.valor());
		System.out.println("Current Degrees: " + ambiente.getDegrees() + ". New Degree: " + newDegreesValue);
		ambiente.setDegrees(newDegreesValue);

		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return (this.getExpressao().getTipo(ambiente).isInteger());
	}
}