package plp.programebrincando.expression.binary;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoExpressaoComando;

public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "+");
	}

	@Override
	public Valor avaliar(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorInteiro valorEsquerda = (ValorInteiro) expressaoEsquerda.avaliar(ambiente);
		ValorInteiro valorDireita = (ValorInteiro) expressaoDireita.avaliar(ambiente);

		return new ValorInteiro(valorEsquerda.valor() + valorDireita.valor());
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoExpressaoComando.INTEGER;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (expressaoEsquerda.getTipo(amb).isInteger() || expressaoEsquerda.getTipo(amb).isParametro())
				&& (expressaoDireita.getTipo(amb).isInteger() || expressaoDireita.getTipo(amb).isParametro());
	}
}