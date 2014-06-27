package plp.programebrincando.command.declaration;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;

public class DeclaracaoParametro {

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
		ambiente.map(id, null);
		return ambiente;
	}
}