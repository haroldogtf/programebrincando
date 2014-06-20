package plp.programebrincando.memory;

import plp.programebrincando.expression.value.Color;
import plp.programebrincando.expression.value.Valor;

public interface AmbienteExecucao extends Ambiente<Valor> {
	public Integer getLimitAxisX();
	public void setLimitAxisX(Integer limitAxisX);
	public Integer getLimitAxisY();
	public void setLimitAxisY(Integer limitAxisY);
	public Integer getCurrentAxisX();
	public void setCurrentAxisX(Integer currentAxisX);
	public Integer getCurrentAxisY();
	public void setCurrentAxisY(Integer currentAxisY);
	public AmbienteExecucao clone();
	public Integer getDegrees();
	public void setDegrees(Integer degrees);
	public Boolean getPenUse();
	public void setPenUse(Boolean penUse);
	public Color getPenColor();
	public void setPenColor(Color penColor);
}