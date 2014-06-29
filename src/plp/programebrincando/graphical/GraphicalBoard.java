package plp.programebrincando.graphical;

import java.awt.ComponentOrientation;

import javax.swing.JFrame;

public class GraphicalBoard extends JFrame{

	private static final long serialVersionUID = 1L;

	private static final int DELAY_TIME = 500;
	
	private Koopa tartaruga;
	private int sizeX;
	private int sizeY;
	private int currentX;
	private int currentY;

	public GraphicalBoard(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.currentX = sizeX / 2;
		this.currentY = sizeY / 2;
		
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(sizeX, sizeY);
		this.setTitle("Programe Brincando");
		this.setVisible(true);
		
		this.tartaruga = new Koopa();
		this.tartaruga.setBounds(currentX - Koopa.WIDTH/2,
								 currentY - Koopa.HEIGHT/2,
								 Koopa.WIDTH,
								 Koopa.HEIGHT);
		this.add(tartaruga);
		this.repaint();
	}
	
	//TODO cordenadas invertidas (x e y invertidos)
	public void pintar(int newX, int newY, int angulo,
			           boolean caneta,
			           int r, int g, int b) {		
		
		newY = getHeight() - newY;
		if(newY < 0){
			newY *= -1;
		}
		
		try {
			Thread.sleep(DELAY_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.add(new Movimento(sizeX, sizeY, currentX, currentY, newX, newY, caneta, r, g, b));
		this.tartaruga.setBounds(newX - Koopa.WIDTH/2, newY - Koopa.HEIGHT, Koopa.WIDTH, Koopa.HEIGHT);
		this.tartaruga.setAngulo(-angulo);
		this.tartaruga.repaint();
		this.repaint();
		
		this.currentX = newX;
		this.currentY = newY;
	}

}
