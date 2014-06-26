package plp.programebrincando.expression;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoPrimitivo;

public class IfThenElse implements Expressao {

	public Expressao expressaoCondicao;
	public Expressao expressaoThen;
	public Expressao expressaoElse;
	
	public IfThenElse(Expressao expressaoCondicao, Expressao expressaoThen, Expressao expressaoElse) {
		this.expressaoCondicao = expressaoCondicao;
		this.expressaoThen = expressaoThen;
		this.expressaoElse = expressaoElse;
	}
	
	@Override
	public String toString() {
		return "if(" + expressaoCondicao.toString() + ")" + " then " + expressaoThen.toString() + " else " + expressaoElse.toString();
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		
		ValorBooleano condicao = (ValorBooleano) expressaoCondicao.avaliar(amb);
		
		if(condicao.valor()){
			return expressaoThen.avaliar(amb);
		}
		else {
			return expressaoElse.avaliar(amb);
		}
		
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		
		boolean retorno;
		
		retorno = (expressaoCondicao.checaTipo(amb)
				&& expressaoCondicao.getTipo(amb).isBoolean()
				&& expressaoThen.checaTipo(amb)
				&& expressaoElse.checaTipo(amb));
		
		return retorno;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		//TODO Confirma se este deve ser o retorno
		return TipoPrimitivo.BOOLEAN;
	}
}