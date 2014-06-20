package plp.programebrincando.expression;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;

public class IfThenElse implements Expressao {

	public Expressao expressao;
	public Expressao expressaoThen;
	public Expressao expressaoElse;
	
	public IfThenElse(Expressao expressao, Expressao expressaoThen, Expressao expressaoElse) {
		this.expressao = expressao;
		this.expressaoThen = expressaoThen;
		this.expressaoElse = expressaoElse;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "if(" + expressao.toString() + ")" + " then " + expressaoThen.toString() + " else " + expressaoElse.toString();
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		// TODO Auto-generated method stub
		return null;
	}
}