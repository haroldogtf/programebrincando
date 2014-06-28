package plp.programebrincando.util;

import plp.programebrincando.command.action.Acao;
import plp.programebrincando.command.action.AcaoParaTras;
import plp.programebrincando.command.action.AcaoParaFrente;
import plp.programebrincando.memory.AmbienteExecucao;

public class AlgoritmoAndarUtil {

	public static ResultadoPodeAndar podeAndar(Acao action, AmbienteExecucao ambiente, Integer passos){
		ResultadoPodeAndar retorno = null;
		if(action instanceof AcaoParaFrente){
			retorno = podeAndarFrente((AcaoParaFrente) action, ambiente, passos);
		}else if(action instanceof AcaoParaTras){
			retorno = podeAndarTras((AcaoParaTras) action, ambiente, passos);
		}
		return retorno;
	}
	
	private static ResultadoPodeAndar podeAndarFrente(AcaoParaFrente actionForward, AmbienteExecucao ambiente, Integer passos){
		Integer degree = ambiente.getDegrees();
		
		Double fatorX = Math.cos(Math.toRadians(degree));
		Double fatorY = Math.sin(Math.toRadians(degree));
		
		Double passosX = passos * fatorX;
		Double passosY = passos * fatorY;

		return passouLimiteXY(passosX, passosY, ambiente);
	}
	
	private static ResultadoPodeAndar podeAndarTras(AcaoParaTras actionBack, AmbienteExecucao ambiente, Integer passos){
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