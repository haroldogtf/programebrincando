package plp.programebrincando.graphical;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Koopa extends JLabel {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 31;
	public static final int HEIGHT = 37;
	
	private int angulo = 0;
	
	public Koopa() {          
		ImageIcon icone = new ImageIcon(this.getClass().getResource("koopa.gif"));
		this.setIcon(icone);
		this.setSize(WIDTH, HEIGHT);
	}
	
	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics.create();
        graphics2D.rotate(Math.toRadians(angulo), WIDTH/2, HEIGHT/2);	
        
		super.paintComponent(graphics2D);
	}
	
}