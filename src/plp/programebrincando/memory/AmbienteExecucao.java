package plp.programebrincando.memory;

import plp.programebrincando.command.declaration.DefinicaoProcedimento;
import plp.programebrincando.exception.ProcedimentoJaDeclaradoException;
import plp.programebrincando.exception.ProcedimentoNaoDeclaradoException;
import plp.programebrincando.expression.Id;
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
	public void changeValor(Id id, Valor avaliar);
	public void mapProcedimento(Id idProcedimento, DefinicaoProcedimento definicaoProcedimento) throws ProcedimentoJaDeclaradoException;
	public DefinicaoProcedimento getProcedimento(Id idProcedimento) throws ProcedimentoNaoDeclaradoException;
}