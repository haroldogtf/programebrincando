package plp.programebrincando.expression.value;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoPrimitivo;

public class ValorCor extends ValorConcreto<Cor>{
	
	public ValorCor(Cor valor){
		super(valor);
		
		System.out.println(toString());
	}
	
	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoPrimitivo.COR;
	}
}