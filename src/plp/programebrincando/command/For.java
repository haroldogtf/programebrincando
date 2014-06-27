package plp.programebrincando.command;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class For implements Comando {

	public Expressao expressaoLoop;
	public Comando comandoExecucao;

	public For(Expressao expressaoLoop, Comando expressaoExecucao) {
		this.expressaoLoop = expressaoLoop;
		this.comandoExecucao = expressaoExecucao;
	}

	@Override
	public String toString() {
		return "for " + expressaoLoop.toString() + ", " + comandoExecucao.toString();	
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		while (((ValorBooleano) expressaoLoop.avaliar(ambiente)).valor()) {
			ambiente = comandoExecucao.executar(ambiente);
		}
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return expressaoLoop.checaTipo(ambiente)
				&& expressaoLoop.getTipo(ambiente).isBoolean()
				&& comandoExecucao.checaTipo(ambiente);
	}
}