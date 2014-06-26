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
		
		Double fatorX = Math.cos(Math.toRadians(degree));
		Double fatorY = Math.sin(Math.toRadians(degree));
		
		Double passosX = passos * fatorX;
		Double passosY = passos * fatorY;

		return passouLimiteXY(passosX, passosY, ambiente);
	}
	
	private static ResultadoPodeAndar podeAndarTras(ActionBack actionBack, AmbienteExecucao ambiente, Integer passos){
		Integer degree = ambiente.getDegrees();
		
		Double fatorX = Math.cos(Math.toRadians(degree));
		Double fatorY = Math.sin(Math.toRadians(degree));
		
		Double passosX = passos * fatorX;
		Double passosY = passos * fatorY;
		
		return passouLimiteXY(-passosX, -passosY, ambiente);
	}
	
	private static ResultadoPodeAndar passouLimiteXY(Double passosX, Double passosY, AmbienteExecucao ambiente){
		Double newAxisX = passosX + ambiente.getCurrentAxisX(); 
		Double newAxisY = passosY + ambiente.getCurrentAxisY();
		boolean podeAndar = (newAxisX <= ambiente.getLimitAxisX() && newAxisX >= 0) && 
				(newAxisY <= ambiente.getLimitAxisY() && newAxisY >= 0);
		
		return new ResultadoPodeAndar(podeAndar, newAxisX, newAxisY);
	}
}