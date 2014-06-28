package plp.programebrincando.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Id;

public class Contexto<T> {

	protected Stack<HashMap<Id, T>> pilha;

	public Contexto() {
		pilha = new Stack<HashMap<Id, T>>();
	}

	public void incrementa() {
		pilha.push(new HashMap<Id, T>());
	}

	public void restaura() {
		pilha.pop();
	}

	public void map(Id id, T valor) throws VariavelJaDeclaradaException {
		try {
			if(!pilha.isEmpty()){
				HashMap<Id, T> aux = pilha.peek();
				if (aux.put(id, valor) != null){
					throw new IdentificadorJaDeclaradoException();
				}
			}else{
				Map<Id, T> map = new HashMap<Id, T>();
				map.put(id, valor);
				pilha.push((HashMap<Id, T>) map);
			}
		} catch (IdentificadorJaDeclaradoException e) {
			throw new VariavelJaDeclaradaException(id);
		}
	}

	public void changeValor(Id id, T valor) throws VariavelNaoDeclaradaException{
		Object result = null;
		Stack<HashMap<Id, T>> auxStack = new Stack<HashMap<Id, T>>();
		Stack<HashMap<Id, T>> stack = this.pilha;
		
		while (result == null && !stack.empty()) {
			HashMap<Id,T> aux = stack.pop();
			auxStack.push(aux);
			result = aux.get(id);
			if (result != null) {
				aux.put(id, valor);
			}
		}
		while (!auxStack.empty()) {
			stack.push(auxStack.pop());
		}
		if (result == null) {
			throw new VariavelNaoDeclaradaException(id);
		}
	}
	
	public T get(Id idArg) throws VariavelNaoDeclaradaException {
		try {
			T result = null;
			Stack<HashMap<Id, T>> auxStack = new Stack<HashMap<Id, T>>();
			while (result == null && !pilha.empty()) {
				HashMap<Id, T> aux = pilha.pop();
				auxStack.push(aux);
				result = aux.get(idArg);
			}

			while (!auxStack.empty()) {
				pilha.push(auxStack.pop());
			}

			if (result == null){
				throw new IdentificadorNaoDeclaradoException();
			}
			return result;
		} catch (IdentificadorNaoDeclaradoException e) {
			throw new VariavelNaoDeclaradaException(idArg);
		}
	}

	protected Stack<HashMap<Id, T>> getPilha() {
		return pilha;
	}

	protected void setPilha(Stack<HashMap<Id, T>> pilha) {
		this.pilha = pilha;
	}
}
