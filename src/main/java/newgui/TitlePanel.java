package newgui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TitlePanel extends WhitePanel {
	private static final long serialVersionUID = -311065542322641285L;

	TitlePanel(){
		setLayout(new BorderLayout());
		JLabel title = new JLabel(new ImageIcon("image/title.png"));
		title.setBackground(new Color(0,0,0,0));
		title.setBounds(300, 190, 447, 243);
		add(title);
		
	}
}
