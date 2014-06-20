package plp.programebrincando;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.memory.AmbienteCompilacao;

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
	
	
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException{
		return expressao.checaTipo(ambiente);
	}
}