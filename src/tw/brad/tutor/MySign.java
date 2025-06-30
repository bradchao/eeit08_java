package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyDrawer;
import tw.brad.apis.MyDrawer2;

public class MySign extends JFrame{
	private MyDrawer2 myDrawer;
	private JButton clear, undo, redo, color;
	
	public MySign() {
		super("簽名 App");
		
		myDrawer = new MyDrawer2();
		setLayout(new BorderLayout());
		add(myDrawer);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear"); top.add(clear);
		undo = new JButton("Undo"); top.add(undo);
		redo = new JButton("Redo"); top.add(redo);
		color = new JButton("Color"); top.add(color);
		
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
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "Change Color", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.changeColor(newColor);
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
