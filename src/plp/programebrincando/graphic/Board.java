package plp.programebrincando.graphic;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame {

	public JPanel lbl;

	private static final long serialVersionUID = -6614892168679208028L;

	public Board() {
		initUI();
	}

	private void initUI() {

		setTitle("Programe Brincando");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		// SwingUtilities.invokeLater(new Runnable() {
		//
		// @Override
		// public void run() {

		Board b = new Board();
		
		int width = 400;
		int height = 300;
		
		int xCenter = width/2;
		int yCenter = height/2;
		
		b.setSize(width+5, height+50);
		
		List<String> actions = new ArrayList<String>();
		actions.add("LINE " + (xCenter) + " " + (yCenter) + " " + (xCenter) + " " + (yCenter - 50));
		actions.add("COLOR " + 255 + " " + 0 + " " + 0); //RED
		actions.add("LINE " + (xCenter) + " " + (yCenter - 50) + " " + (xCenter - 50) + " " + (yCenter - 50));
		actions.add("COLOR " + 0 + " " + 255 + " " + 0); //GREEN
		actions.add("LINE " + (xCenter - 50) + " " + (yCenter - 50) + " " + (xCenter - 50) + " " + (yCenter));
		actions.add("USEPEN " + "false");
		actions.add("LINE " + (xCenter - 50) + " " + (yCenter) + " " + (xCenter) + " " + (yCenter));
		actions.add("COLOR " + 0 + " " + 0 + " " + 255); //BLUE
		actions.add("LINE " + (xCenter) + " " + (yCenter) + " " + (xCenter + 50) + " " + (yCenter));
		actions.add("LINE " + (xCenter) + " " + (yCenter) + " " + (xCenter + 100) + " " + (yCenter));
		
		DrawOutput pbdo = new DrawOutput(new Dimension(width, height), actions);
		
		b.add(pbdo);

		b.setVisible(true);
	}
}
