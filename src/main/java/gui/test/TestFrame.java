package gui.test;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import data.init.DataInit;

public class TestFrame extends JFrame {
	private static final long serialVersionUID = -4771769317423285893L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AnimationConfigurationManager.getInstance().allowAnimations(AnimationFacet.ROLLOVER);
					//AnimationConfigurationManager.getInstance().allowAnimations(AnimationFacet.SELECTION);
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		new DataInit().init();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setSize(new Dimension(1024,698));
		//this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel pnl = new TestStatisticPanel();
		pnl.setBounds(180, 20, 800, 600);
		contentPane.add(pnl);
		
		

	}


}
