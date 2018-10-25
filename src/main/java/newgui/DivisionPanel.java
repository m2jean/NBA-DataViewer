package newgui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class DivisionPanel extends ColoredPanel {

	private static final long serialVersionUID = 5220530758171478425L;

	public DivisionPanel(String division, int align, ImageIcon[] teams) {
		super(MainFrame.theme_color,120);
		this.setLayout(new BorderLayout());
		
		Container contnr_division = new Container();
		contnr_division.setLayout(new FlowLayout(align));
		this.add(contnr_division,BorderLayout.NORTH);
		
		JLabel lbl_division = new JLabel(division);
		lbl_division.setForeground(MainFrame.theme_color);
		lbl_division.setFont(new Font("黑体",Font.BOLD,20));
		contnr_division.add(lbl_division);
		
		Container contnr_teams = new Container();
		contnr_teams.setLayout(new FlowLayout(FlowLayout.CENTER));
		for(ImageIcon icon: teams){
			contnr_teams.add(new JLabel(icon));
		}
		this.add(contnr_teams);
	}

}
