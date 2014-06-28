package plp.programebrincando.expression.binary;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.expression.value.ValorConcreto;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoExpressaoComando;

public class ExpressaoIgual extends ExpressaoBinaria {

	public ExpressaoIgual(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "==");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorConcreto valorEsquerda = (ValorConcreto) expressaoEsquerda.avaliar(amb);
		ValorConcreto valorDireita = (ValorConcreto) expressaoDireita.avaliar(amb);
		
		return new ValorBooleano(valorEsquerda.isEquals(valorDireita));
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoExpressaoComando.BOOLEAN;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressaoEsquerda.getTipo(amb).isEqual(expressaoDireita.getTipo(amb));		
	}

}