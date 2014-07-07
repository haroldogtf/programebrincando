package plp.programebrincando.memory;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

import plp.programebrincando.arduino.ArduinoGenerator;
import plp.programebrincando.command.declaration.DefinicaoProcedimento;
import plp.programebrincando.exception.ProcedimentoJaDeclaradoException;
import plp.programebrincando.exception.ProcedimentoNaoDeclaradoException;
import plp.programebrincando.exception.VariavelJaDeclaradaException;
import plp.programebrincando.exception.VariavelNaoDeclaradaException;
import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.value.Color;
import plp.programebrincando.expression.value.Valor;
import plp.programebrincando.graphical.GraphicalGenerator;

public class ContextoExecucao extends Contexto<Valor> implements AmbienteExecucao {

	private Integer degrees;

	private Double limitAxisX;
	private Double limitAxisY;

	private Double currentAxisX;
	private Double currentAxisY;

	private Boolean penUse = true;
	
	private Color penColor = new Color(0, 0, 0);
	
	private Contexto<DefinicaoProcedimento> contextoProcedimentos;
	
	public ContextoExecucao(int limitX, int limitY) {
		contextoProcedimentos = new Contexto<DefinicaoProcedimento>();
		
		degrees = 0;

		limitAxisX = (double) limitX;
		limitAxisY = (double) limitY;
		
		currentAxisX = limitAxisX / 2;
		currentAxisY = limitAxisY / 2;
				
		GraphicalGenerator.inicializar(limitX, limitY);
		ArduinoGenerator.inicializar();
	}

	public ContextoExecucao clone() {
		
		int limitX = ((int)((double) limitAxisX));
		int limitY = ((int)((double) limitAxisY));
		
		ContextoExecucao retorno = new ContextoExecucao(limitX, limitY);
		
		Stack<HashMap<Id, Valor>> novaPilha = new Stack<HashMap<Id, Valor>>();
		
		HashMap<Id, Valor> novoMap = new HashMap<Id, Valor>();
		novaPilha.add(novoMap);

		for (HashMap<Id, Valor> map : this.pilha){
			for(Entry<Id, Valor> entry : map.entrySet()){
				novoMap.put(entry.getKey(), entry.getValue());
			}
		}
		retorno.setPilha(novaPilha);
		return retorno;
	}

	public Double getLimitAxisX() {
		return limitAxisX;
	}

	public void setLimitAxisX(Double limitAxisX) {
		this.limitAxisX = limitAxisX;
	}

	public Double getLimitAxisY() {
		return limitAxisY;
	}

	public void setLimitAxisY(Double limitAxisY) {
		this.limitAxisY = limitAxisY;
	}

	public Double getCurrentAxisX() {
		return currentAxisX;
	}

	public void setCurrentAxisX(Double currentAxisX) {
		this.currentAxisX = currentAxisX;
	}

	public Double getCurrentAxisY() {
		return currentAxisY;
	}

	public void setCurrentAxisY(Double currentAxisY) {
		this.currentAxisY = currentAxisY;
	}

	public Boolean getPenUse() {
		return penUse;
	}

	public void setPenUse(Boolean penUse) {
		this.penUse = penUse;
	}

	public Color getPenColor() {
		return penColor;
	}

	public void setPenColor(Color penColor) {
		this.penColor = penColor;
	}

	public Integer getDegrees() {
		return degrees;
	}

	public void setDegrees(Integer degrees) {
		this.degrees = degrees;
	}

	@Override
	public void mapProcedimento(Id idProcedimento, DefinicaoProcedimento definicaoProcedimento) throws ProcedimentoJaDeclaradoException {
		try {
			this.contextoProcedimentos.map(idProcedimento, definicaoProcedimento);
		} catch (VariavelJaDeclaradaException e) {
			throw new ProcedimentoJaDeclaradoException(idProcedimento);
		}		
	}

	@Override
	public DefinicaoProcedimento getProcedimento(Id idProcedimento) throws ProcedimentoNaoDeclaradoException {
		try {
			return this.contextoProcedimentos.get(idProcedimento);
		} catch (VariavelNaoDeclaradaException e) {
			throw new ProcedimentoNaoDeclaradoException(idProcedimento);
		}
	}
}