package plp.programebrincando.util;

import plp.programebrincando.expression.unary.action.Action;
import plp.programebrincando.expression.unary.action.ActionBack;
import plp.programebrincando.expression.unary.action.ActionForward;
import plp.programebrincando.expression.unary.action.ActionLeft;
import plp.programebrincando.expression.unary.action.ActionRight;
import plp.programebrincando.memory.AmbienteExecucao;

public class AlgoritmoGirarUtil {

	public static Integer girar(Action action, AmbienteExecucao ambiente, Integer graus){
		Integer retorno = null;
		if(action instanceof ActionRight){
			retorno = podeAndarFrente((ActionForward) action, ambiente, graus);
		}else if(action instanceof ActionLeft){
			retorno = podeAndarTras((ActionBack) action, ambiente, graus);
		}
		return retorno;
	}
	
	private static Integer podeAndarFrente(ActionForward actionForward, AmbienteExecucao ambiente, Integer graus){
		Integer degree = ambiente.getDegrees();
		
		int fatorX = (int) Math.round(Math.cos(Math.toRadians(degree)));
		int fatorY = (int) Math.round(Math.sin(Math.toRadians(degree)));
		
		int passosX = passos * fatorX;
		int passosY = passos * fatorY;

		return passouLimiteXouY(passosX, passosY, ambiente);
	}
	
	private static Integer podeAndarTras(ActionBack actionBack, AmbienteExecucao ambiente, Integer graus){
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