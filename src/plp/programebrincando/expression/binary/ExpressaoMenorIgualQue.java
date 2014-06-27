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
import plp.programebrincando.util.TipoExpressao;

public class ExpressaoMenorIgualQue extends ExpressaoBinaria {

	public ExpressaoMenorIgualQue(Expressao expressaoEsquerda, Expressao expressaoDireita) {
		super(expressaoEsquerda, expressaoDireita, "<=");
	}

	@Override
	public Valor avaliar(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ValorInteiro valorEsquerda = (ValorInteiro) expressaoEsquerda.avaliar(ambiente);
		ValorInteiro valorDireita = (ValorInteiro) expressaoDireita.avaliar(ambiente);

		return new ValorBooleano(valorEsquerda.valor() <= valorDireita.valor());
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoExpressao.BOOLEAN;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return expressaoEsquerda.getTipo(amb).isInteger() && expressaoDireita.getTipo(amb).isInteger();		
	}

}
