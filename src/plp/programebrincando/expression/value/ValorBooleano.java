package plp.programebrincando.expression.value;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoExpressao;


public class ValorBooleano extends ValorConcreto<Boolean>{

	public ValorBooleano(boolean valor) {
		super(valor);
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoExpressao.BOOLEAN;
	}
}