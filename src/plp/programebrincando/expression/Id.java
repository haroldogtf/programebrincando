package plp.programebrincando.expression;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;

public class Id implements Expressao {

	private String idName;
	
	public Id(String idName) {
		this.idName = idName;
	}
	
	@Override
	public String toString() {
		return idName;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		amb.get(this);
		return true;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return amb.get(this);
	}

	@Override
	public Valor avaliar(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException{
		return ambiente.get(this);
	}
}