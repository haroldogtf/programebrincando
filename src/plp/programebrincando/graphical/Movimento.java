package plp.programebrincando.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Movimento extends JPanel {

	private static final long serialVersionUID = 1L;

	private int currentX;
	private int currentY;
	private int newX;
	private int newY;
	private boolean caneta;
	private int r;
	private int g;
	private int b;
	
	public Movimento(int sizeX,    int sizeY,
			         int currentX, int currentY,
			         int newX,     int newY,
			         boolean caneta,
			         int r, int g, int b) {
		
		this.setBackground(new Color(1, true));
		this.setSize(sizeX, sizeY);
		
		this.currentX = currentX;
		this.currentY = currentY;
		this.newX     = newX;
		this.newY     = newY;
		this.caneta   = caneta;
		this.r        = r;
		this.g        = g;
		this.b        = b;		
	}


	@Override
	public void paintComponent(Graphics graphical) {
		super.paintComponent(graphical);
		
		Graphics2D graphical2D = (Graphics2D) graphical;
		if(this.caneta) {
			graphical2D.setColor(new Color(r, g, b, 255));
		} else {
			graphical2D.setColor(new Color(0, 0, 0, 0));

		}	
		graphical2D.drawLine(this.currentX, this.currentY, this.newX, this.newY);
	}
}