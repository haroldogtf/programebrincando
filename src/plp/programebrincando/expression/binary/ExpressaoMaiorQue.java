package plp.programebrincando.expression.binary;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.expression.value.ValorInteiro;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoPrimitivo;


public class ExpressaoMaiorQue extends ExpressaoBinaria {

	public ExpressaoMaiorQue(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, ">");
	}

	@Override
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorInteiro valorEsquerda = (ValorInteiro) expressaoEsquerda.avaliar(amb);
		ValorInteiro valorDireita = (ValorInteiro) expressaoDireita.avaliar(amb);

		return new ValorBooleano(valorEsquerda.valor() > valorDireita.valor());
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoPrimitivo.BOOLEAN;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressaoEsquerda.getTipo(amb).isInteger() && expressaoDireita.getTipo(amb).isInteger();		
	}

}
