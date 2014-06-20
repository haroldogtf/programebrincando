package plp.programebrincando.expression.unary.action;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Color;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.expression.value.ValorCor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoPrimitivo;

public class ActionSetPenColor extends Action {

	private static final String operador = "CORCANETA";
	
	public ActionSetPenColor(Expressao expressao) {
		super(expressao, operador);
		System.out.println(this);
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		
		ValorCor valorCor = (ValorCor) expressao.avaliar(amb);
		Color cor = valorCor.valor();
		
		Valor retorno = null;
		
		if((cor.red >=  0 || cor.red <= 255) || (cor.green >=  0 || cor.green <= 255) || (cor.blue >=  0 || cor.blue <= 255)){
			amb.setPenColor(cor);
			retorno = new ValorBooleano(true);
			System.out.println(cor + " CORCANETA ");
		}else{
			retorno = new ValorBooleano(false);
			System.out.println(" SKIP CORCANETA ");
		}
		return retorno;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoPrimitivo.BOOLEAN;
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (this.getExpressao().getTipo(amb).isInteger());
	}
}