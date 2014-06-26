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

public class ActionForward extends Action {

	private static final String operador = "PARAFRENTE";
	
	public ActionForward(Expressao expressao) {
		super(expressao, operador);
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorInteiro numeroPassos = (ValorInteiro) expressao.avaliar(amb);
		ResultadoPodeAndar resultadoPodeAndar = AlgoritmoAndarUtil.podeAndar(this, amb, numeroPassos.valor());
		
		ValorBooleano retorno = new ValorBooleano(resultadoPodeAndar.isPodeAndar());
		
		if(retorno.valor()){
			amb.setCurrentAxisX(resultadoPodeAndar.getNewAxisX());
			amb.setCurrentAxisY(resultadoPodeAndar.getNewAxisY());
			System.out.println(numeroPassos + " -> ");
		}else{
			System.out.println(" SKIP -> ");
		}
		return retorno;
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (this.getExpressao().getTipo(amb).isInteger());
	}
	
	public static void main(String[] args) {
		System.out.println("Sin90 = " + Math.sin(Math.toRadians(90)));
		System.out.println("Cos90 = " + Math.round(Math.cos(Math.toRadians(90))));
	}
}