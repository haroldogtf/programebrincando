package plp.programebrincando.expression.unary.action;

import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorCor;

public class ActionSetPenColor extends Acao {

	public Valor valor;
	
	public ActionSetPenColor(Valor valor){
		this.valor = valor;
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "CORCANETA " + ((ValorCor)valor).toString();
	}
}