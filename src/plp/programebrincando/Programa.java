package plp.programebrincando;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class Programa {

	private Expressao expressao;
	
	public Programa(Expressao expressao){
		this.expressao = expressao;
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}
	
	public boolean checaTipo(AmbienteCompilacao ambiente){
		boolean valido = false;
		try {
			valido = expressao.checaTipo(ambiente);
		} catch (VariavelNaoDeclaradaException | VariavelJaDeclaradaException e) {
			e.printStackTrace();
		}
		return valido;
	}
	
	public void executar(AmbienteExecucao ambiente) {
		try {
			expressao.avaliar(ambiente);
		} catch (VariavelNaoDeclaradaException | VariavelJaDeclaradaException e) {
			e.printStackTrace();
		}
	}
}