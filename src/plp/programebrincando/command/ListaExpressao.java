package plp.programebrincando.command;

import java.util.LinkedList;
import java.util.List;

import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.Lista;
import plp.programebrincando.expression.ListaValor;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.Tipo;

public class ListaExpressao extends Lista<Expressao> {

	public Id head;
	public ListaExpressao tail;

	public ListaExpressao() {

	}

	public ListaExpressao(Expressao expressao) {
		super(expressao, new ListaExpressao());
	}

	public ListaExpressao(Expressao expressao, ListaExpressao listaExpressao) {
		super(expressao, listaExpressao);
	}
	
	public ListaValor avaliar(AmbienteExecucao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		if (length() >= 2){
			return new ListaValor(getHead().avaliar(ambiente), ((ListaExpressao) getTail()).avaliar(ambiente));
		}else if (length() == 1){
			return new ListaValor(getHead().avaliar(ambiente));
		}else{
			return new ListaValor();
		}
	}

	public List<Tipo> getTipos(AmbienteCompilacao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		List<Tipo> result = new LinkedList<Tipo>();

		if (this.length() >= 2) {
			result.add(getHead().getTipo(ambiente));
			result.addAll(((ListaExpressao) getTail()).getTipos(ambiente));
		} else if (length() == 1) {
			result.add(getHead().getTipo(ambiente));
		}
		return result;
	}
}