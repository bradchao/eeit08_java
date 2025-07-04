package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.GamePanel;

public class BallGame extends JFrame{
	private GamePanel panel;
	
	public BallGame() {
		setLayout(new BorderLayout());
		
		panel = new GamePanel();
		add(panel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new BallGame();
	}

}
