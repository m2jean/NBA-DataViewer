package newgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JToggleButton;


public class SideMenuContainer extends Container {

	private static final long serialVersionUID = 6362569446834435592L;
	protected Map<String, JToggleButton> btn_map = new HashMap<String, JToggleButton>();

	public SideMenuContainer(String[] texts, int align) {
		this.setLayout(new FlowLayout(align, 0, 10));
		
		for(String s : texts){
			ColoredPanel pnl = new ColoredPanel(MainFrame.theme_color,50);
			pnl.setLayout(new BorderLayout());
			pnl.setSize(70,160);
			pnl.setPreferredSize(new Dimension(45,120));
			pnl.setOpaque(false);
			add(pnl);
			
			JToggleButton btn = new VerticalToggleButton(s);
			btn.setActionCommand(s);
			btn.setFont(new Font("黑体",Font.BOLD,17));
			btn.setSize(btn.getPreferredSize());
			//btn.setBackground(MainFrame.theme_color);
			btn.setBackground(Color.white);

			btn.setFocusable(false);
			btn.setBorderPainted(false);
			
			btn_map.put(s, btn);
			pnl.add(btn);
		}
	}

}
