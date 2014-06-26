package plp.programebrincando.memory;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

import plp.programebrincando.expression.Id;
import plp.programebrincando.expression.value.Color;
import plp.programebrincando.expression.value.Valor;

public class ContextoExecucao extends Contexto<Valor> implements AmbienteExecucao {

	//TODO Colocar como entrada o limites
	private Integer degrees = 90;

	private Double limitAxisX = 100.0;
	private Double limitAxisY = 100.0;

	private Double currentAxisX = limitAxisX / 2;
	private Double currentAxisY = limitAxisY / 2;

	private Boolean penUse = true;
	
	private Color penColor = new Color(0, 0, 0);
	
	
	public ContextoExecucao clone() {
		ContextoExecucao retorno = new ContextoExecucao();
		
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
}