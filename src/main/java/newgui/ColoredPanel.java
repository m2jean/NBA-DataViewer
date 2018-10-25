package newgui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Paint;

import javax.swing.JPanel;

public class ColoredPanel extends JPanel {
	private static final long serialVersionUID = -5675963128942960368L;
	protected Color paint_color = MainFrame.theme_color;

	@Override
	protected void paintComponent(Graphics g) {
		if (g instanceof Graphics2D) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setPaint(paint_color);
			g2d.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	public ColoredPanel(){
		super();
	}
	
	public ColoredPanel(Color color, int alpha){
		this();
		this.setColor(color, alpha);
	}

	public void setColor(int red,int green,int blue,int alpha){
		paint_color = new Color(red,green,blue,alpha);
	}
	
	public void setColor(Color color, int alpha){
		paint_color = new Color(color.getRed(),color.getGreen(),color.getBlue(),alpha);
	}
	
	public void setAlpha(int alpha){
		Color c = paint_color;
		paint_color = new Color(c.getRed(),c.getGreen(),c.getBlue(),120);
	}
}
