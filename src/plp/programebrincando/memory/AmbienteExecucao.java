package plp.programebrincando.memory;

import plp.programebrincando.expression.value.Color;
import plp.programebrincando.expression.value.Valor;

public interface AmbienteExecucao extends Ambiente<Valor> {
	public Double getLimitAxisX();
	public void setLimitAxisX(Double limitAxisX);
	public Double getLimitAxisY();
	public void setLimitAxisY(Double limitAxisY);
	public Double getCurrentAxisX();
	public void setCurrentAxisX(Double currentAxisX);
	public Double getCurrentAxisY();
	public void setCurrentAxisY(Double currentAxisY);
	public AmbienteExecucao clone();
	public Integer getDegrees();
	public void setDegrees(Integer degrees);
	public Boolean getPenUse();
	public void setPenUse(Boolean penUse);
	public Color getPenColor();
	public void setPenColor(Color penColor);
}