package plp.programebrincando.expression.value;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoExpressaoComando;

public class ValorInteiro extends ValorConcreto<Integer>{

	public ValorInteiro(int valor){
		super(valor);
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoExpressaoComando.INTEGER;
	}
}