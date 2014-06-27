package plp.programebrincando.expression.unary.action;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.AlgoritmoAndarUtil;
import plp.programebrincando.util.ResultadoPodeAndar;

public class ActionBack extends Action {

	private static final String operador = "PARATRAS";
	
	public ActionBack(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public Valor avaliar(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorInteiro numeroPassos = (ValorInteiro) expressao.avaliar(ambiente);
		ResultadoPodeAndar resultadoPodeAndar = AlgoritmoAndarUtil.podeAndar(this, ambiente, numeroPassos.valor());
		
		ValorBooleano retorno = new ValorBooleano(resultadoPodeAndar.isPodeAndar());
		
		if(retorno.valor()){
			System.out.println(numeroPassos + " <- Current Coordinates: " + ambiente.getCurrentAxisX() + " " + 
					ambiente.getCurrentAxisY() + ". Current Degrees: " + ambiente.getDegrees() + ". New Coordinates: " +
					resultadoPodeAndar.getNewAxisX() + " " + resultadoPodeAndar.getNewAxisY());
			ambiente.setCurrentAxisX(resultadoPodeAndar.getNewAxisX());
			ambiente.setCurrentAxisY(resultadoPodeAndar.getNewAxisY());
		}else{
			System.out.println(" SKIP back");
		}
		return retorno;
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (this.getExpressao().getTipo(amb).isInteger());
	}
}