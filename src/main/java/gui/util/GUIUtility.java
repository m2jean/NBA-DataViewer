package gui.util;

import java.text.DecimalFormat;

public class GUIUtility {
/*
	public static FocusAdapter getFocusAdapter(){
		return new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(e.getSource() instanceof JTextField)
					((JTextField)e.getSource()).selectAll();
				else if(e.getSource() instanceof JTextArea)
					((JTextArea)e.getSource()).selectAll();
			}
		};
	}
	
	public static FocusListener getFocusListenerForInt(JTextField txf,Component parent){
		return new IntegerInputListener(txf,parent);
	}
	public static FocusListener getFocusListenerForDouble(JTextField txf,Component parent){
		return new DoubleInputListener(txf,parent);
	}
	
	private static class IntegerInputListener implements FocusListener{
		private String temp = "";
		private JTextField txf;
		private Component parent;
		
		IntegerInputListener(JTextField txf,Component parent){
			this.txf = txf;
			this.parent = parent;
		}
		
		@Override
		public void focusGained(FocusEvent arg0) {
			txf.selectAll();
			temp = txf.getText();
		}
		@Override
		public void focusLost(FocusEvent e) {
			if(!txf.getText().trim().matches("\\d+")){
				JOptionPane.showMessageDialog(parent, "请输入合法的整数！");
				txf.setText(temp);
			}			
		}		
	}
	
	private static class DoubleInputListener implements FocusListener{
		private String temp = "";
		private JTextField txf;
		private Component parent;
		
		DoubleInputListener(JTextField txf,Component parent){
			this.txf = txf;
			this.parent = parent;
		}
		
		@Override
		public void focusGained(FocusEvent arg0) {
			txf.selectAll();
			temp = txf.getText();
		}
		@Override
		public void focusLost(FocusEvent e) {
			if(!txf.getText().trim().matches("\\d*\\.?\\d+")){
				JOptionPane.showMessageDialog(parent, "请输入合法的小数！");
				txf.setText(temp);
			}			
		}		
	}
	*/
	public static String formatDouble(double d){
		if(d == Double.NaN) return "0.0";
		DecimalFormat nf;
		//if(d-(int)d > 0.001)
			nf = new DecimalFormat("##0.00");
		//else
			//nf = new DecimalFormat("##0");
		nf.setDecimalSeparatorAlwaysShown(false);
		nf.setMaximumFractionDigits(2);
		return nf.format(d);
	}
}
