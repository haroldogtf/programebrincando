package plp.programebrincando.expression;

public class ForwardMovement extends Acao {

	Valor valor;
	
	public ForwardMovement(Valor valor) {
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