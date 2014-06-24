package plp.programebrincando.expression.unary.action;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class ActionRight extends Action {

	private static final String operador = "GIRARDIREITA";
	
	public ActionRight(Expressao expressao) {
		super(expressao, operador);
		System.out.println(this);
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		/*
		 * TODO Fazer representação visual
		 * 1. Elaborar algoritmo para verificar se o robo pode andar.
		 * 2. Caso, o robo possa andar, atualizar as coordenadas e retorne true
		 * 3. Caso contrário, o robo não anda, e o método retorna false. 
		 */
		ValorInteiro number = (ValorInteiro) expressao.avaliar(amb);
		Valor retorno = null;
		
		boolean valor = true;
		
		if(valor){
			int x = amb.getCurrentAxisX();
			
			//TODO Fazer um algoritmo para atualizar o grau de inclinação.
			amb.setDegrees(amb.getDegrees() + x);
			retorno = new ValorBooleano(true);
			System.out.println(number + " GD ");
		}else{
			retorno = new ValorBooleano(false);
			System.out.println(" SKIP GD ");
		}
		return retorno;
	}

	@Override
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (this.getExpressao().getTipo(amb).isInteger());
	}
}