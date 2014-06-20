package plp.programebrincando.memory;

import plp.programebrincando.expression.value.Valor;

public interface AmbienteExecucao extends Ambiente<Valor> {

	public AmbienteExecucao clone();

}