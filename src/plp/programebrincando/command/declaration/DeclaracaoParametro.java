package plp.programebrincando.command.declaration;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.TipoExpressaoComando;

public class DeclaracaoParametro implements Declaracao {

	private Id id;

	public DeclaracaoParametro(Id id) {
		this.id = id;
	}

	public Id getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
	
	public AmbienteCompilacao elabora(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.map(id, TipoExpressaoComando.PARAMETRO);
		return ambiente;
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		// TODO Auto-generated method stub
		return false;
	}
}