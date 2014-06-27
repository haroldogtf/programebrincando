package plp.programebrincando;

import plp.programebrincando.command.Comando;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class Programa {

	private Comando comando;
	
	public Programa(Comando comando){
		this.comando = comando;
	}

	public Comando getComando() {
		return comando;
	}

	public void setComando(Comando comando) {
		this.comando = comando;
	}
	
	public boolean checaTipo(AmbienteCompilacao ambiente){
		boolean valido = false;
		try {
			valido = comando.checaTipo(ambiente);
		} catch (IdentificadorJaDeclaradoException | IdentificadorNaoDeclaradoException e) {
			e.printStackTrace();
		}
		return valido;
	}
	
	public void executar(AmbienteExecucao ambiente) {
		try {
			comando.executar(ambiente);
		} catch (IdentificadorJaDeclaradoException | IdentificadorNaoDeclaradoException e) {
			e.printStackTrace();
		}
	}
}