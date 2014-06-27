package plp.programebrincando.command;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public interface Comando {
	AmbienteExecucao executar(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException;
	boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException;
}