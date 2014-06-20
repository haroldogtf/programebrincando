package plp.programebrincando.expression.unary.action;

import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorInteiro;

public class ActionLeft extends Acao {

	Valor valor;
	
	public ActionLeft(Valor valor) {
		this.valor = valor;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String retorno = "";
		if(valor instanceof ValorInteiro){
			retorno = "GIRARESQUERDA " + valor.toString();
		}
		return retorno;
	}
}