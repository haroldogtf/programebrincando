package plp.programebrincando.util;

public class ResultadoPodeAndar {

	private boolean podeAndar;
	private Double newAxisX;
	private Double newAxisY;
	
	public ResultadoPodeAndar(boolean podeAndar, Double newAxisX, Double newAxisY) {
		this.podeAndar = podeAndar;
		this.newAxisX = newAxisX;
		this.newAxisY = newAxisY;
	}

	public boolean isPodeAndar() {
		return podeAndar;
	}

	public Double getNewAxisX() {
		return newAxisX;
	}

	public Double getNewAxisY() {
		return newAxisY;
	}

	@Override
	public String toString() {
		return "ResultadoPodeAndar [podeAndar=" + podeAndar + ", newAxisX="
				+ newAxisX + ", newAxisY=" + newAxisY + "]";
	}
}