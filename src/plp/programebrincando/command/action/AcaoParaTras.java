package plp.programebrincando.command.action;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.move.AlgoritmoAndar;
import plp.programebrincando.move.ResultadoPodeAndar;

public class AcaoParaTras extends Acao {

	private static final String operador = "PARATRAS";
	
	public AcaoParaTras(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {

		ValorInteiro numeroPassos = (ValorInteiro) super.getExpressao().avaliar(ambiente);
		ResultadoPodeAndar resultadoPodeAndar = AlgoritmoAndar.podeAndar(this, ambiente, numeroPassos.valor());
		
		if(resultadoPodeAndar.isPodeAndar()){
			System.out.println(numeroPassos + " <- Current Coordinates: " + ambiente.getCurrentAxisX() + " " + 
					ambiente.getCurrentAxisY() + ". Current Degrees: " + ambiente.getDegrees() + ". New Coordinates: " +
					resultadoPodeAndar.getNewAxisX() + " " + resultadoPodeAndar.getNewAxisY());
			ambiente.setCurrentAxisX(resultadoPodeAndar.getNewAxisX());
			ambiente.setCurrentAxisY(resultadoPodeAndar.getNewAxisY());
		}else{
			System.out.println(" SKIP back");
		}
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return (this.getExpressao().getTipo(ambiente).isInteger());
	}
}