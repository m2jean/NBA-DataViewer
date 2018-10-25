package gui.test;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;





public class A {
	protected String a;
	A(){
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setVisible(true);
				
				JTable tbl = new JTable(new String[][]{{"a","b","c"},{"a","b","c"},{"a","b","c"},{"a","b","c"}},new String[]{"a","b","c"});
				frame.add(tbl);
				
				frame.pack();
				
			}
			
		});
		
	}
	

}
