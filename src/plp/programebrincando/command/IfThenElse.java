package plp.programebrincando.command;

import java.util.Map;

import plp.programebrincando.command.declaration.DeclaracaoParametro;
import plp.programebrincando.exception.IdentificadorJaDeclaradoException;
import plp.programebrincando.exception.IdentificadorNaoDeclaradoException;
import plp.programebrincando.expression.Expressao;
import plp.programebrincando.expression.value.ValorBooleano;
import plp.programebrincando.memory.AmbienteCompilacao;
import plp.programebrincando.memory.AmbienteExecucao;

public class IfThenElse implements Comando {

	public Expressao expressaoCondicao;
	public Comando comandoThen;
	public Comando comandoElse;
	
	public IfThenElse(Expressao expressaoCondicao, Comando comandoThen, Comando comandoElse) {
		this.expressaoCondicao = expressaoCondicao;
		this.comandoThen = comandoThen;
		this.comandoElse = comandoElse;
	}
	
	@Override
	public String toString() {
		return "if(" + expressaoCondicao.toString() + ")" + " then " + comandoThen.toString() + " else " + comandoElse.toString();
	}

	@Override
	public AmbienteExecucao executar(AmbienteExecucao ambiente) throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException{
		if (((ValorBooleano) expressaoCondicao.avaliar(ambiente)).valor()){
			return comandoThen.executar(ambiente);
		}else{
			return comandoElse.executar(ambiente);
		}
	}

	@Override
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException {
		return expressaoCondicao.checaTipo(ambiente) && expressaoCondicao.getTipo(ambiente).isBoolean()
				&& comandoThen.checaTipo(ambiente) && comandoElse.checaTipo(ambiente);
	}

	@Override
	public Comando redefinirParametro(Map<DeclaracaoParametro, DeclaracaoParametro> map) {
		return this;
	}
}