package plp.programebrincando.expression;

public class RightMovement extends Acao {

	Valor valor;
	
	public RightMovement(Valor valor) {
		this.valor = valor;
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String retorno = "";
		if(valor instanceof ValorInteiro){
			retorno = "GIRARDIREITA " + valor.toString();
		}
		return retorno;
	}
}