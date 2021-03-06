package plp.programebrincando.command.declaration;

import java.util.Map;

import plp.programebrincando.command.Comando;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;
import plp.programebrincando.util.TipoExpressaoComando;

public class DeclaracaoParametro implements Declaracao {

	private Id id;

	public DeclaracaoParametro(Id id) {
		this.id = id;
	}

	public Id getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
	
	public AmbienteCompilacao elabora(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.map(id, TipoExpressaoComando.PARAMETRO);
		return ambiente;
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeclaracaoParametro other = (DeclaracaoParametro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Comando redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map) {
		DeclaracaoParametro declaracaoParametro;
		if(map.get(id) != null){
			declaracaoParametro = new DeclaracaoParametro(map.get(id).getId());
		}else{
			declaracaoParametro = new DeclaracaoParametro(id);
		}
		return declaracaoParametro;
	}
}