package plp.programebrincando.expression;

public class BackMovement extends Acao {

	Valor valor;
	
	public BackMovement(Valor valor) {
		this.valor = valor;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String retorno = "";
		if(valor instanceof ValorInteiro){
			retorno = "PARATRAS " + valor.toString();
		}
		return retorno;
	}
}