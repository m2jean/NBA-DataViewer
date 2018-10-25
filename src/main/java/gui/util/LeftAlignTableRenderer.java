package gui.util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class LeftAlignTableRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = -2523889612380403370L;

	@Override
	public
	Component getTableCellRendererComponent(JTable table, Object value, 
		boolean isSelected, boolean hasFocus, int row, int column){
		JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		lbl.setHorizontalAlignment(SwingConstants.LEADING);
		lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		//lbl.setFont(new Font(lbl.getFont().getName(),Font.PLAIN,lbl.getFont().getSize()));
		if(table.getModel().getColumnClass(column) == int.class || table.getModel().getColumnClass(column) == Integer.class){
			lbl.setText(String.valueOf((int)value));
			
			return lbl;
		}
		else if(table.getModel().getColumnClass(column) == double.class || table.getModel().getColumnClass(column) == Double.class){
			lbl.setText(GUIUtility.formatDouble((double)value));
			return lbl;
		}
		return lbl;
		
	}

}
