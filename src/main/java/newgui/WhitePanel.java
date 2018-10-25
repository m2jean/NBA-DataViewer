package newgui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

public class WhitePanel extends JPanel {
	private static final long serialVersionUID = 9207647649352691333L;

	@Override
    protected void paintComponent(Graphics g) {
         if (g instanceof Graphics2D) {
             final int R = 255;
             final int G = 255;
             final int B = 255;

             Paint p = new Color(R,G,B,160);
             Graphics2D g2d = (Graphics2D)g;
             g2d.setPaint(p);
             g2d.fillRoundRect(0, 0, getWidth()-3, getHeight()-3,15,15);
             
             g2d.setPaint(new GradientPaint(getWidth()-3, 10, new Color(59,99,147,50), getWidth(), 10,new Color(0,0,0,0)));
             g2d.fillRect(getWidth()-3, 10, 3, getHeight()-15);
             g2d.setPaint(new GradientPaint(10, getHeight()-3, new Color(59,99,147,50), 10, getHeight(),new Color(0,0,0,0)));
             g2d.fillRect(10, getHeight()-3, getWidth()-15, 3);
         }
     }
	
	public WhitePanel(){
		this.setOpaque(false);
	}
}
