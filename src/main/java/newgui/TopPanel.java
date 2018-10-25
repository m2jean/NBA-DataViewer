package newgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class TopPanel extends JPanel {
	private static final long serialVersionUID = 3241141467926437774L;
	
	@Override
    protected void paintComponent(Graphics g) {
        if (g instanceof Graphics2D) {
            final int R = 255;
            final int G = 255;
            final int B = 255;

            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(new Color(R,G,B,160));
            g2d.fillRect(0, 0, getWidth(), getHeight()-3);
            
            g2d.setPaint(new GradientPaint(0, getHeight()-3, new Color(59,99,147,50), 0, getHeight(),new Color(0,0,0,0)));
            g2d.fillRect( 0, getHeight()-3,getWidth(), 3);
        }
    }
	
	public TopPanel(final Window window){
		setPreferredSize(new Dimension(1024,40));
		this.setLayout(null);
		
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("image/icon/button_close.png"));
		btn.setBackground(new Color(255,255,255,0));
		btn.setBounds(1024-35-5,0, 35, 35);
		btn.setFocusable(false);
		btn.setBorderPainted(false);
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
				System.exit(0);
			}
		});
		
		add(btn);
	}
}
