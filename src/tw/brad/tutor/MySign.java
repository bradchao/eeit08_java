package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.brad.apis.MyDrawer;
import tw.brad.apis.MyDrawer2;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo, color;
	private JButton saveJpg, saveObject, loadObject;
	
	public MySign() {
		super("簽名 App");
		
		myDrawer = new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear"); top.add(clear);
		undo = new JButton("Undo"); top.add(undo);
		redo = new JButton("Redo"); top.add(redo);
		color = new JButton("Color"); top.add(color);
		saveJpg = new JButton("Save JPEG"); top.add(saveJpg);
		saveObject = new JButton("Save Object"); top.add(saveObject);
		loadObject = new JButton("Load Object"); top.add(loadObject);
		
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
		
		saveJpg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveJpeg();
			}
		});
		
		saveObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});
		loadObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObj();
			}
		});
		
		
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "Change Color", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.changeColor(newColor);
		}
	}
	
	private void saveJpeg() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				if (myDrawer.saveJPEG(saveFile)) {
					JOptionPane.showMessageDialog(this, "Save Success");
				}else {
					JOptionPane.showMessageDialog(this, "Save Failure");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save Failure");
			}
		}
	}
	
	private void saveObj() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				myDrawer.saveLines(saveFile);
				JOptionPane.showMessageDialog(this, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save Failure");
			}
		}
	}

	private void loadObj() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File loadFile = jfc.getSelectedFile();
			try {
				myDrawer.loadLines(loadFile);;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Load Failure");
			}
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
