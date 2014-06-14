package plp.programebrincando.expression;

public class LeftMovement extends Acao {

	Valor valor;
	
	public LeftMovement(Valor valor) {
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