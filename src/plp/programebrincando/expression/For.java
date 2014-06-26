package plp.programebrincando.expression;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoPrimitivo;

public class For implements Expressao {

	public Expressao expressaoRepeticao;
	public Expressao expressaoExecucao;

	public For(Expressao expressaoLoop, Expressao expressaoExecucao) {
		this.expressaoRepeticao = expressaoLoop;
		this.expressaoExecucao = expressaoExecucao;
	}

	@Override
	public String toString() {
		return "for " + expressaoRepeticao.toString() + ", " + expressaoExecucao.toString();	
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		
		Valor repeticao = expressaoRepeticao.avaliar(amb);
		
		if(repeticao instanceof ValorInteiro) {
			
			ValorInteiro valor = (ValorInteiro) repeticao;
			
			for(int i = 0; i < valor.valor(); i++) {
				expressaoExecucao.avaliar(amb);
			}	
		}
	
		/*
		 * TODO Quando o resultado da expressão for um boleano
		 * Porem só dá para testar essa parte quando aplicação estiver ok, pois váriáveis podem mudar de valor a cada iteração
		 * Se não houver mudaça se torna um loop infinito
		 * 

		if(repeticao instanceof ValorBooleano) {
			
			ValorBooleano valor = (ValorBooleano) repeticao;

			while(valor.valor()) {
				expressaoExecucao.avaliar(amb);
						
				repeticao = expressaoRepeticao.avaliar(amb);
				valor = (ValorBooleano) repeticao;				
			}
			
		}
		*/
		
		// TODO verificar o tipo de Retorno! Retornando null e está funcionando, só confirmar se deve ser isso mesmo ou se deve mudar
		return null;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		
		
		boolean retorno;
		
		/*
		 * TODO Essa expressão será subistituida quando no avaliar já estiver sendo possível usar inteiros e boleanos
		retorno = (expressaoRepeticao.checaTipo(amb)
				&& (expressaoRepeticao.getTipo(amb).isBoolean()
						|| expressaoRepeticao.getTipo(amb).isInteger())
				&& expressaoExecucao.checaTipo(amb));
		*/
		
		retorno = (expressaoRepeticao.checaTipo(amb)
				&& expressaoRepeticao.getTipo(amb).isInteger()
				&& expressaoExecucao.checaTipo(amb));
		
		return retorno;
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		//TODO Confirma se este deve ser o retorno
		return TipoPrimitivo.BOOLEAN;
	}

}