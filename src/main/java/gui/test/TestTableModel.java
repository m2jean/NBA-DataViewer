package gui.test;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TestTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"Long String","Double","Integer"};
	private ArrayList<Object> data = new ArrayList<Object>();

	public TestTableModel() {
		data.add("sdkljfkdsjfkdsjfkjdsjfkd");
		data.add(1.9/34*3499.34353578);
		data.add(7800);
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}
	
	@Override
	public String getColumnName(int col){
		return header[col];
	}

	@Override
	public int getRowCount() {
		return data==null?0:5;
	}
	
	@Override
	public Class<?> getColumnClass(int col){
		return data.get(col).getClass(); 
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object result = null;
		switch(col){
		case 0:
			result = data.get(0);
			break;
		case 1:
			result = data.get(1);
			break;
		case 2:
			result = data.get(2);
			break;
		case 3:
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
