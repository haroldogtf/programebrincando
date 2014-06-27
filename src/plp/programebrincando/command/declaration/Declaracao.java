package plp.programebrincando.command.declaration;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public interface Declaracao {
	public abstract AmbienteExecucao elabora(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException;

	public abstract boolean checaTipo(AmbienteCompilacao ambiente) 
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException;
}