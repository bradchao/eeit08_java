package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.brad.apis.GiftTable;

public class MyGift extends JFrame{
	private GiftTable table;
	private JButton del;
	
	public MyGift() {
		super("伴手禮");
		
		setLayout(new BorderLayout());
		
		del = new JButton("Delete");
		JPanel top = new JPanel(new FlowLayout());
		top.add(del);
		add(top, BorderLayout.NORTH);
		
		table = new GiftTable();
		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.delRow();
			}
		});
	}
	
	public static void main(String[] args) {
		new MyGift();
	}

}
