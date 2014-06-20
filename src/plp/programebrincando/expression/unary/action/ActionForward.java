package plp.programebrincando.expression.unary.action;

import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorInteiro;

public class ActionForward extends Acao {

	Valor valor;
	
	public ActionForward(Valor valor) {
		this.valor = valor;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String retorno = "";
		if(valor instanceof ValorInteiro){
			retorno = "PARAFRENTE " + valor.toString();
		}
		return retorno;
	}
}