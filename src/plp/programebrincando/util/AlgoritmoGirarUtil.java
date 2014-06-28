package plp.programebrincando.util;

import plp.programebrincando.command.action.Acao;
import plp.programebrincando.command.action.AcaoGirarEsquerda;
import plp.programebrincando.command.action.AcaoGirarDireita;
import plp.programebrincando.memory.AmbienteExecucao;

public class AlgoritmoGirarUtil {

	public static Integer girar(Acao action, AmbienteExecucao ambiente, Integer degrees){
		Integer retorno = null;
		if(action instanceof AcaoGirarDireita){
			retorno = girarDireita((AcaoGirarDireita) action, ambiente, degrees);
		}else if(action instanceof AcaoGirarEsquerda){
			retorno = girarEsquerda((AcaoGirarEsquerda) action, ambiente, degrees);
		}
		return retorno;
	}
	
	private static Integer girarDireita(AcaoGirarDireita actionRight, AmbienteExecucao ambiente, Integer degrees){
		Integer currentDegrees = ambiente.getDegrees();
		Integer newDegreesValue = currentDegrees - degrees;
		newDegreesValue = normalizarDegrees(newDegreesValue);
		
		return newDegreesValue;
	}
	
	private static Integer girarEsquerda(AcaoGirarEsquerda actionLeft, AmbienteExecucao ambiente, Integer degrees){
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