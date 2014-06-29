package plp.programebrincando.command.action;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Color;
import plp.programebrincando.expression.value.ValorCor;
import plp.programebrincando.graphical.GraphicalGenerator;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class AcaoCorCaneta extends Acao {

	private static final String operador = "CORCANETA";
	
	public AcaoCorCaneta(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		ValorCor valorCor = (ValorCor) super.getExpressao().avaliar(ambiente);
		Color cor = valorCor.valor();
		
		if((cor.red >= 0 && cor.red <= 255) && (cor.green >=  0 && cor.green <= 255) && (cor.blue >= 0 && cor.blue <= 255)) {
			ambiente.setPenColor(cor);
			
			System.out.println(cor + " RGB ");
			GraphicalGenerator.pintar(ambiente);
			
		}else{
			System.out.println(" SKIP CORCANETA ");
		}
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return this.getExpressao().getTipo(ambiente).isColor() || this.getExpressao().getTipo(ambiente).isParametro();		
	}
}