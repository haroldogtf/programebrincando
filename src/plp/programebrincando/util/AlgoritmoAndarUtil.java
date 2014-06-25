package plp.programebrincando.util;

import plp.programebrincando.expression.unary.action.Action;
import plp.programebrincando.expression.unary.action.ActionBack;
import plp.programebrincando.expression.unary.action.ActionForward;
import plp.programebrincando.memory.AmbienteExecucao;

public class AlgoritmoAndarUtil {

	public static ResultadoPodeAndar podeAndar(Action action, AmbienteExecucao ambiente, Integer passos){
		ResultadoPodeAndar retorno = null;
		if(action instanceof ActionForward){
			retorno = podeAndarFrente((ActionForward) action, ambiente, passos);
		}else if(action instanceof ActionBack){
			retorno = podeAndarTras((ActionBack) action, ambiente, passos);
		}
		return retorno;
	}
	
	private static ResultadoPodeAndar podeAndarFrente(ActionForward actionForward, AmbienteExecucao ambiente, Integer passos){
		Integer degree = ambiente.getDegrees();
		
		int fatorX = (int) Math.round(Math.cos(Math.toRadians(degree)));
		int fatorY = (int) Math.round(Math.sin(Math.toRadians(degree)));
		
		int passosX = passos * fatorX;
		int passosY = passos * fatorY;

		return passouLimiteXouY(passosX, passosY, ambiente);
	}
	
	private static ResultadoPodeAndar podeAndarTras(ActionBack actionBack, AmbienteExecucao ambiente, Integer passos){
		Integer degree = ambiente.getDegrees();
		
		int fatorX = (int) Math.round(Math.cos(Math.toRadians(degree)));
		int fatorY = (int) Math.round(Math.sin(Math.toRadians(degree)));
		
		int passosX = passos * fatorX;
		int passosY = passos * fatorY;
		
		return passouLimiteXouY(-passosX, -passosY, ambiente);
	}
	
	private static ResultadoPodeAndar passouLimiteXouY(int passosX, int passosY, AmbienteExecucao ambiente){
		Integer newAxisX = passosX + ambiente.getCurrentAxisX(); 
		Integer newAxisY = passosY + ambiente.getCurrentAxisY();
		boolean podeAndar = (newAxisX <= ambiente.getLimitAxisX() && newAxisX >= 0) && 
				(newAxisY <= ambiente.getLimitAxisY() && newAxisY >= 0);
		
		return new ResultadoPodeAndar(podeAndar, newAxisX, newAxisY);
	}
}