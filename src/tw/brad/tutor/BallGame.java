package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.GamePanel;
import tw.brad.apis.GamePanel2;

public class BallGame extends JFrame{
	private GamePanel2 panel;
	
	public BallGame() {
		setLayout(new BorderLayout());
		
		panel = new GamePanel2();
		add(panel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new BallGame();
	}

}
