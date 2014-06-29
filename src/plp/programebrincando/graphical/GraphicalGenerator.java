package plp.programebrincando.graphical;

import plp.programebrincando.memory.AmbienteExecucao;

public class GraphicalGenerator {

	private static GraphicalBoard board; 
	
	public static void inicializar(int sizeX, int sizeY) {
		board = new GraphicalBoard(sizeX, sizeY);
	}
	
	private static void pintar(double newX, double newY, int angulo,
							  boolean caneta,
							  int r, int g, int b) {
		
		board.pintar((int)newX, (int)newY, angulo, caneta, r, g, b);
	}
	
	public static void pintar(AmbienteExecucao ambiente) {
		pintar(ambiente.getCurrentAxisX(),
				  ambiente.getCurrentAxisY(),
				  ambiente.getDegrees(),
				  ambiente.getPenUse(),
				  ambiente.getPenColor().red,
				  ambiente.getPenColor().green,
				  ambiente.getPenColor().blue);
	}
	
}
