package newgui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TitleContainer extends Container {
	private static final long serialVersionUID = -311065542322641285L;

	TitleContainer(ActionListener enterListener){
		setLayout(null);
		JLabel title = new JLabel(new ImageIcon("image/title.png"));
		title.setBackground(new Color(0,0,0,0));
		title.setBounds(300, 190, 447, 243);
		add(title);
		
		JButton btn = new JButton("ENTER");
		btn.setForeground(new Color(59,99,147));
		btn.setBackground(new Color(59,99,147,20));
		btn.setFont(new Font("MonoType Corsiva",Font.BOLD,40));
		btn.setBounds(385,500, 250, 60);
		btn.setFocusable(false);
		btn.setBorderPainted(false);
		btn.addActionListener(enterListener);
		add(btn);
	}
}
