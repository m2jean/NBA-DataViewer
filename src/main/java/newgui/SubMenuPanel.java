package newgui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;


public class SubMenuPanel extends ColoredPanel {
	private static final long serialVersionUID = -3925773823220046063L;
	HashMap<String, JButton> btn_map = new HashMap<String, JButton>(7);
	/*
	@Override
	protected void paintComponent(Graphics g) {
		if (g instanceof Graphics2D) {
			Color c = MainFrame.theme_color;

			Paint p = new Color(c.getRed(),c.getGreen(),c.getBlue(),120);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setPaint(p);
			g2d.fillRect(0, 0, getWidth(), getHeight());
		}
	}*/

	public SubMenuPanel(String[] texts) {
		this.setColor(MainFrame.theme_color, 120);
		// this.setDoubleBuffered(false);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);

		this.add(Box.createHorizontalGlue());
		for (int i = 0; i < texts.length; i++) {
			JButton btn = new JButton(texts[i]);

			btn.setForeground(MainFrame.underscore_color);
			btn.setBackground(MainFrame.theme_color);
			btn.setFont(new Font("黑体", Font.PLAIN, 17));

			btn.setFocusable(false);
			btn.setBorderPainted(false);
			btn.setOpaque(false);

			btn_map.put(texts[i], btn);
			btn.setPreferredSize(new Dimension(106, 40));
			this.add(btn);
			this.add(Box.createHorizontalGlue());
		}
	}
	
	public void addActionListener(ActionListener al, String btn_text){
		btn_map.get(btn_text).addActionListener(al);
	}
}
