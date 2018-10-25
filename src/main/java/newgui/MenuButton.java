package newgui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;


public class MenuButton extends JToggleButton {
	private static final long serialVersionUID = 2911660310046983526L;

	public MenuButton(String iconPath,String text){
		setIcon(new ImageIcon(iconPath));
		setText(text);
		
		setForeground(MainFrame.theme_color);
		setBackground(new Color(255,255,255,0));
		setFont(new Font("黑体",Font.BOLD,25));
		this.setIconTextGap(20);
		
		setFocusable(false);
		setBorderPainted(false);
		this.setOpaque(false);
		
	}
	
}
