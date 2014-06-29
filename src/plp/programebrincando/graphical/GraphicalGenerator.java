package plp.programebrincando.graphical;

import java.io.IOException;

public class GraphicalGenerator {

	private static GraphicalBoard board; 
	
	public static void inicializar(int sizeX, int sizeY) {
		board = new GraphicalBoard(sizeX, sizeY);
	}
	
	public static void pintar(int newX, int newY, int angulo,
							  boolean caneta,
							  int r, int g, int b) {
		
		board.pintar(newX, newY, angulo, caneta, r, g, b);
	}
	
	//TODO cordenadas invertidas (x e y invertidos)
	// apagar o main depois de pronto
	public static void main(String[] args) throws InterruptedException, IOException {
		GraphicalGenerator.inicializar(800, 600);
		
		while(true) {
			GraphicalGenerator.pintar(300, 150, 0, false, 255, 0, 0);
			GraphicalGenerator.pintar(200, 150, 90, true, 255, 0, 0);
			GraphicalGenerator.pintar(200, 200, 30, true, 255, 255, 0);
			GraphicalGenerator.pintar(150, 200, 270, true, 255, 0, 0);
			GraphicalGenerator.pintar(150, 150, 0, false, 255, 0, 0);
			GraphicalGenerator.pintar(200, 150, 140, true, 255, 0, 255);
			GraphicalGenerator.pintar(200, 200, 0, false, 255, 0, 0);
			GraphicalGenerator.pintar(150, 200, 200, false, 0, 0, 0);
			GraphicalGenerator.pintar(150, 200, 0, true, 255, 255, 255);
		}	
	}
	
}
