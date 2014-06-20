package plp.programebrincando.expression.unary.action;

import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.expression.value.ValorBooleano;

public class ActionSetPenUse extends Acao {

	public Valor valor;
	
	public ActionSetPenUse(Valor valor){
		this.valor = valor;
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		String retorno = "";
		if(valor instanceof ValorBooleano){
			retorno = ((ValorBooleano) valor).toString(); 
		}
		return retorno;
	}
}