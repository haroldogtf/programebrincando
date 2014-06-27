package plp.programebrincando.expression;

import plp.programebrincando.expression.value.Valor;

public class ListaValor extends Lista<Valor>{

	public ListaValor(){
    
    }

	public ListaValor(Valor valor){
        super(valor, new ListaValor());
    }

    public ListaValor(Valor valor, ListaValor listaValor){
        super(valor, listaValor);
    }

    public void write(Valor valor) {
        if(getHead() == null) {
            this.head = valor;
            this.tail = new ListaValor();
        }else {
            ((ListaValor)getTail()).write(valor);
        }
    }
}