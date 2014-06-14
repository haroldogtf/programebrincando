package plp.programebrincando.expression;

public class SetPenUse extends Acao {

	public Valor valor;
	
	public SetPenUse(Valor valor){
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