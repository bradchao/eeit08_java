package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable {
	private GiftDB db;
	public GiftTable() {
		
		try {
			db = new GiftDB();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		setModel(new GiftModel());
	}
	
	public void delRow() {
		//System.out.println(getSelectedRow());
		int delRow = getSelectedRow();
		if (delRow != -1) {
			db.delData(delRow);
			repaint();
		}
	}

	private class GiftModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}

		@Override
		public String getColumnName(int column) {
			return db.getColName(column);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			db.updateData(row, column, (String)aValue);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column != 0;
		}
		
		
		
		
	}
	
}
