package plp.programebrincando.command;

import java.util.Map;

import plp.programebrincando.command.declaration.DeclaracaoParametro;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class Atribuicao implements Comando {

	private Id id;

	private Expressao expressao;

	public Atribuicao(Id id, Expressao expressao) {
		this.id = id;
		this.expressao = expressao;
	}

	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
		ambiente.changeValor(id, expressao.avaliar(ambiente));
		return ambiente;
	}

	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressao.checaTipo(ambiente);
	}
	
	@Override
	public String toString() {
		return id + " = " + expressao;
	}

	@Override
	public Comando redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map) {
		if(map.get(id) != null){
			this.id = map.get(id).getId();
		}
		return this;
	}
}