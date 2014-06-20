package plp.programebrincando.expression.value;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.util.Tipo;
import plp.programebrincando.util.TipoPrimitivo;

public class ValorInteiro extends ValorConcreto<Integer>{

	public Integer valor;
	
	public ValorInteiro(int valor){
		super(valor);
		
		System.out.println(toString());
	}

	@Override
	public Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return TipoPrimitivo.INTEGER;
	}
}