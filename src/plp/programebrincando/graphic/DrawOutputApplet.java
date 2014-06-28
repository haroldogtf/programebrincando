package plp.programebrincando.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class DrawOutputApplet extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6401612069579804838L;
	private Graphics2D g2 = null;
	final static Color bg = Color.white;
	final static Color fg = Color.black;
	final static Color red = Color.red;
	final static Color white = Color.white;
	
	Dimension totalSize;

	public void init() {
		// Initialize drawing colors
		setBackground(bg);
		setForeground(fg);
	}
	
	public void drawTest(){
		g2.draw(new Line2D.Double(2, 2, 80, 80));
	}

	public void paint(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		totalSize = getSize();
		int xCenter = totalSize.width / 2;
		int yCenter = totalSize.height / 2;
		
		int parafrente = 10;

		// draw Line2D.Double
		g2.draw(new Line2D.Double(xCenter, yCenter, xCenter + parafrente, yCenter));
//		g2.drawString("Line2D", x, stringY);
//		x += gridWidth;
//
//		// draw Rectangle2D.Double
//		g2.setStroke(stroke);
//		g2.draw(new Rectangle2D.Double(x, y, rectWidth, rectHeight));
//		g2.drawString("Rectangle2D", x, stringY);
//		x += gridWidth;
//
//		// draw RoundRectangle2D.Double
//		g2.setStroke(dashed);
//		g2.draw(new RoundRectangle2D.Double(x, y, rectWidth, rectHeight, 10, 10));
//		g2.drawString("RoundRectangle2D", x, stringY);
//		x += gridWidth;
//
//		// draw Arc2D.Double
//		g2.setStroke(wideStroke);
//		g2.draw(new Arc2D.Double(x, y, rectWidth, rectHeight, 90, 135,
//				Arc2D.OPEN));
//		g2.drawString("Arc2D", x, stringY);
//		x += gridWidth;
//
//		// draw Ellipse2D.Double
//		g2.setStroke(stroke);
//		g2.draw(new Ellipse2D.Double(x, y, rectWidth, rectHeight));
//		g2.drawString("Ellipse2D", x, stringY);
//		x += gridWidth;
//
//		// draw GeneralPath (polygon)
//		int x1Points[] = { x, x + rectWidth, x, x + rectWidth };
//		int y1Points[] = { y, y + rectHeight, y + rectHeight, y };
//		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
//				x1Points.length);
//		polygon.moveTo(x1Points[0], y1Points[0]);
//		for (int index = 1; index < x1Points.length; index++) {
//			polygon.lineTo(x1Points[index], y1Points[index]);
//		}
//		;
//		polygon.closePath();
//
//		g2.draw(polygon);
//		g2.drawString("GeneralPath", x, stringY);
//
//		// NEW ROW    public void paintComponent(Graphics g) {

//		x = 5;
//		y += gridHeight;
//		stringY += gridHeight;
//
//		// draw GeneralPath (polyline)
//
//		int x2Points[] = { x, x + rectWidth, x, x + rectWidth };
//		int y2Points[] = { y, y + rectHeight, y + rectHeight, y };
//		GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
//				x2Points.length);
//		polyline.moveTo(x2Points[0], y2Points[0]);
//		for (int index = 1; index < x2Points.length; index++) {
//			polyline.lineTo(x2Points[index], y2Points[index]);
//		}
//		;
//
//		g2.draw(polyline);
//		g2.drawString("GeneralPath (open)", x, stringY);
//		x += gridWidth;
//
//		// fill Rectangle2D.Double (red)
//		g2.setPaint(red);
//		g2.fill(new Rectangle2D.Double(x, y, rectWidth, rectHeight));
//		g2.setPaint(fg);
//		g2.drawString("Filled Rectangle2D", x, stringY);
//		x += gridWidth;
//
//		// fill RoundRectangle2D.Double
//		GradientPaint redtowhite = new GradientPaint(x, y, red, x + rectWidth,
//				y, white);
//		g2.setPaint(redtowhite);
//		g2.fill(new RoundRectangle2D.Double(x, y, rectWidth, rectHeight, 10, 10));
//		g2.setPaint(fg);
//		g2.drawString("Filled RoundRectangle2D", x, stringY);
//		x += gridWidth;
//
//		// fill Arc2D
//		g2.setPaint(red);
//		g2.fill(new Arc2D.Double(x, y, rectWidth, rectHeight, 90, 135,
//				Arc2D.OPEN));
//		g2.setPaint(fg);
//		g2.drawString("Filled Arc2D", x, stringY);
//		x += gridWidth;
//
//		// fill Ellipse2D.Double
//		redtowhite = new GradientPaint(x, y, red, x + rectWidth, y, white);
//		g2.setPaint(redtowhite);
//		g2.fill(new Ellipse2D.Double(x, y, rectWidth, rectHeight));
//		g2.setPaint(fg);
//		g2.drawString("Filled Ellipse2D", x, stringY);
//		x += gridWidth;
//
//		// fill and stroke GeneralPath
//		int x3Points[] = { x, x + rectWidth, x, x + rectWidth };
//		int y3Points[] = { y, y + rectHeight, y + rectHeight, y };
//		GeneralPath filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
//				x3Points.length);
//		filledPolygon.moveTo(x3Points[0], y3Points[0]);
//		for (int index = 1; index < x3Points.length; index++) {
//			filledPolygon.lineTo(x3Points[index], y3Points[index]);
//		}
//		;
//		filledPolygon.closePath();
//		g2.setPaint(red);
//		g2.fill(filledPolygon);
//		g2.setPaint(fg);
//		g2.draw(filledPolygon);
//		g2.drawString("Filled and Stroked GeneralPath", x, stringY);
	}

	public static void main(String s[]) {
		JFrame f = new JFrame("ProgrameBrincando");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		DrawOutputApplet pbDraw = new DrawOutputApplet();
		f.getContentPane().add("Center", pbDraw);
		pbDraw.init();
		f.pack();
		f.setSize(new Dimension(800, 600));
		f.setVisible(true);
	}
}
