package plp.programebrincando.expression;


public class ListaParametros {

	public Id head;
	public ListaParametros tail;

	public ListaParametros() {
	}
	
	public ListaParametros(Id id) {
		this.head = id;
	}
	
	public ListaParametros(Id id, ListaParametros listaParametros) {
		this.head = id;
		this.tail = listaParametros;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		if(head != null){
			sb.append(head.toString());
			toStringTail(sb, tail);
		}
		sb.append(")");
		return sb.toString();
	}
	
	public String toStringTail(StringBuilder sb, ListaParametros lista){
		if(lista.head != null){
			sb.append(", ");
			sb.append(lista.head);
			toStringTail(sb, lista.tail);
		}
		return sb.toString();
	}
}