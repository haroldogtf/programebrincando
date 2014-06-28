package plp.programebrincando.util;

import plp.programebrincando.command.action.Action;
import plp.programebrincando.command.action.ActionLeft;
import plp.programebrincando.command.action.ActionRight;
import plp.programebrincando.memory.AmbienteExecucao;

public class AlgoritmoGirarUtil {

	public static Integer girar(Action action, AmbienteExecucao ambiente, Integer degrees){
		Integer retorno = null;
		if(action instanceof ActionRight){
			retorno = girarDireita((ActionRight) action, ambiente, degrees);
		}else if(action instanceof ActionLeft){
			retorno = girarEsquerda((ActionLeft) action, ambiente, degrees);
		}
		return retorno;
	}
	
	private static Integer girarDireita(ActionRight actionRight, AmbienteExecucao ambiente, Integer degrees){
		Integer currentDegrees = ambiente.getDegrees();
		Integer newDegreesValue = currentDegrees - degrees;
		newDegreesValue = normalizarDegrees(newDegreesValue);
		
		return newDegreesValue;
	}
	
	private static Integer girarEsquerda(ActionLeft actionLeft, AmbienteExecucao ambiente, Integer degrees){
		Integer currentDegrees = ambiente.getDegrees();
		Integer newDegreesValue = currentDegrees + degrees;
		newDegreesValue = normalizarDegrees(newDegreesValue);
		
		return newDegreesValue;
	}
	
	private static Integer normalizarDegrees(Integer degrees){
		degrees = degrees % 360;
		if(degrees < 0){
			degrees = 360 + degrees;
		}
		return degrees;
	}
}