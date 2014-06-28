package plp.programebrincando.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

public class DrawOutput extends JPanel {

	private static final long serialVersionUID = 5568105589316565165L;
	private Graphics2D g2d = null;
	private List<String> actions;
	private Color lastColor;

	/*
	 * #Draw line LINE intXFrom intYFrom intXTo intYTo #Set line color (default
	 * black) COLOR intRed intGreen intBlue #Set usePen USEPEN false/true
	 */

	public DrawOutput(Dimension size, List<String> actions) {
		this.setSize(size);
		this.actions = actions;
	}

	private void doDrawing(Graphics g) {
		g2d = (Graphics2D) g;
		lastColor = new Color(0, 0, 0);
		g2d.setColor(lastColor);
		draw();
	}

	public void draw() {
		String[] action;

		for (String a : actions) {
			action = a.split(" ");
			switch (action[0]) {
			case "LINE":
				drawLine(Integer.parseInt(action[1]),
						Integer.parseInt(action[2]),
						Integer.parseInt(action[3]),
						Integer.parseInt(action[4]));
				break;

			case "COLOR":
				setColor(Integer.parseInt(action[1]),
						Integer.parseInt(action[2]),
						Integer.parseInt(action[3]));
				break;

			case "USEPEN":
				usePen(Boolean.parseBoolean(action[1]));
				break;

			default:
				break;
			}
		}
	}

	private void drawLine(int xFrom, int yFrom, int xTo, int yTo) {
		g2d.drawLine(xFrom, yFrom, xTo, yTo);
	}

	private void setColor(int r, int g, int b, int a) {
		lastColor = new Color(r, g, b, a);
		g2d.setColor(lastColor);
	}

	private void setColor(int r, int g, int b) {
		setColor(r, g, b, 255);
	}

	private void usePen(boolean use) {
		if (use) {
			g2d.setColor(lastColor);
		} else {
			setColor(0, 0, 0, 0);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}