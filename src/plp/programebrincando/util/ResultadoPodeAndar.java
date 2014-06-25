package plp.programebrincando.util;

public class ResultadoPodeAndar {

	private boolean podeAndar;
	private Integer newAxisX;
	private Integer newAxisY;
	
	public ResultadoPodeAndar(boolean podeAndar, Integer newAxisX, Integer newAxisY) {
		this.podeAndar = podeAndar;
		this.newAxisX = newAxisX;
		this.newAxisY = newAxisY;
	}

	public boolean isPodeAndar() {
		return podeAndar;
	}

	public Integer getNewAxisX() {
		return newAxisX;
	}

	public Integer getNewAxisY() {
		return newAxisY;
	}

	@Override
	public String toString() {
		return "ResultadoPodeAndar [podeAndar=" + podeAndar + ", newAxisX="
				+ newAxisX + ", newAxisY=" + newAxisY + "]";
	}
}