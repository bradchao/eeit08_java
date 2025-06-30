package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo;
	
	public MySign() {
		super("簽名 App");
		
		myDrawer = new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear"); top.add(clear);
		undo = new JButton("Undo"); top.add(undo);
		redo = new JButton("Redo"); top.add(redo);
		
		add(top, BorderLayout.NORTH);
		
		setSize(800, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
