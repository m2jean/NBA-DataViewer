package newgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import enums.Division;

public class TeamPanel extends WhitePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeamPanel() {
		this.setLayout(new BorderLayout());
		
		Container contnr_west = new Container();
		contnr_west.setLayout(new BoxLayout(contnr_west,BoxLayout.Y_AXIS));
		add(contnr_west,BorderLayout.WEST);
		
		JLabel lbl_west = new JLabel("<html><center>西<br/><br/>部<center/><html>");
		lbl_west.setFont(new Font("黑体",Font.BOLD,28));
		lbl_west.setForeground(MainFrame.theme_color);
		lbl_west.setAlignmentX(0.5f);
		lbl_west.setHorizontalAlignment(JLabel.CENTER);
		lbl_west.setPreferredSize(new Dimension(85,200));
		contnr_west.add(lbl_west);
		
		String[] texts = new String[3];
		for(int i = 0;i < 3;i++)
			texts[i] = Division.getWesternDivision()[i+1].toString();
		SideMenuContainer menu_west = new SideMenuContainer(texts,FlowLayout.RIGHT);
		menu_west.setPreferredSize(new Dimension(45,480));
		contnr_west.add(menu_west);
		
		Container contnr_east = new Container();
		contnr_east.setLayout(new BoxLayout(contnr_east,BoxLayout.Y_AXIS));
		add(contnr_east,BorderLayout.EAST);
		
		JLabel lbl_east = new JLabel("<html>东<br/><br/>部<html>");
		lbl_east.setFont(new Font("黑体",Font.BOLD,28));
		lbl_east.setForeground(MainFrame.theme_color);
		lbl_east.setAlignmentX(0.5f);
		lbl_east.setHorizontalAlignment(JLabel.CENTER);
		lbl_east.setPreferredSize(new Dimension(89,200));
		contnr_east.add(lbl_east);
		
		texts = new String[3];
		for(int i = 0;i < 3;i++)
			texts[i] = Division.getEasternDivision()[i+1].toString();
		SideMenuContainer menu_east = new SideMenuContainer(texts,FlowLayout.LEFT);
		menu_east.setPreferredSize(new Dimension(45,480));
		contnr_east.add(menu_east);
		
		Map<String, JToggleButton> btn_map = menu_west.btn_map;
		btn_map.putAll(menu_east.btn_map);
		ButtonGroup btn_grp = new ButtonGroup();
		for(Division d: Division.getDivision()){
			JToggleButton b = btn_map.get(d.toString());
			btn_grp.add(b);
			b.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent ie) {
					if(ie.getStateChange() == ItemEvent.SELECTED);//TODO
				}
			});
		}
		
		Container contnr_center = new Container();
		contnr_center.setLayout(null);
		add(contnr_center);
		
		JPanel pnl_division = new ColoredPanel(MainFrame.light_color,120);
		pnl_division.setBounds(0,10,641,590);
		contnr_center.add(pnl_division);
	}

	private class TeamLabelPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final float WEST = 0;
		public static final float EAST = 1;
		private float direction;
		
		@Override
		protected void paintComponent(Graphics g){
			if (g instanceof Graphics2D) {
	             final int R = 255;
	             final int G = 255;
	             final int B = 255;
	             Paint p = new Color(R,G,B,160);
	             
	             final int left = (int)(direction*10);
	             final int right = (int)(10-direction*10);
	             Graphics2D g2d = (Graphics2D)g;
	             g2d.setPaint(p);
	             g2d.fillRect((int)(direction*10), 0, getWidth()-10, getHeight());
	             g2d.fillRect(0, left, left, getHeight()-left*2);
	             g2d.fillRect(getWidth()-right, right, right, getHeight()-right*2);
	             g2d.fillArc(0, 0, left*2, left*2, 180, 90);
	             g2d.fillArc(0, getHeight()-left*2, left*2, left*2, 90, 90);
	             g2d.fillArc(getWidth()-right*2, 0, right*2, right*2, 270, 90);
	             g2d.fillArc(getWidth()-right*2, getHeight()-right*2, right*2,right*2, 0, 90);
	         }
		}
		
		public TeamLabelPanel(float conference){
			direction = conference;
			
			String conf = "西部";
			if(conference == 10)
				conf = "东部";
			
			
		}
	}
}
