package plp.programebrincando.command;

import java.util.Map;

import plp.programebrincando.command.declaration.DeclaracaoParametro;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class SequenciaComando implements Comando {

	private Comando comando1;
	private Comando comando2;

	public SequenciaComando(Comando comando1, Comando comando2) {
		this.comando1 = comando1;
		this.comando2 = comando2;
	}

	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException{
		return comando2.executar(comando1.executar(ambiente));
	}

	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException{
		return comando1.checaTipo(ambiente) && comando2.checaTipo(ambiente);
	}
	
	@Override
	public String toString() {
		return comando1 + "; " + comando2;
	}

	@Override
	public Comando redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map) {
		return new SequenciaComando(comando1.redefinirParametro(map), comando2.redefinirParametro(map));
	}
}