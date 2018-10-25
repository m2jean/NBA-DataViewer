package newgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JWindow;
import enums.PanelType;

public class MainFrame extends JWindow {
	private static final long serialVersionUID = -4771769317423285893L;
	public static Color theme_color = new Color(138,178,225);
	public static Color underscore_color = new Color(59,99,147);
	public static Color light_color = new Color(222,231,240);
	private JPanel contentPane;
	private Map<PanelType,Container> panels = new EnumMap<PanelType,Container>(PanelType.class);
	private CardLayout cardlayout;
	private Container main_view;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AnimationConfigurationManager.getInstance().disallowAnimations(AnimationFacet.ROLLOVER);
					//AnimationConfigurationManager.getInstance().disallowAnimations(AnimationFacet.SELECTION);
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		//new DataInit().init();
		//this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.setSize(new Dimension(1024,698));
		//this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel pnl_top = new TopPanel(this);
		contentPane.add(pnl_top,BorderLayout.NORTH);
		
		main_view = new Container();
		cardlayout = new CardLayout();
		main_view.setLayout(cardlayout);
		contentPane.add(main_view);
		
		MainContainer contnr_main = new MainContainer();
		main_view.add(contnr_main,PanelType.MENU.toString());
		
		Container pnl_title = new TitlePanel();
		contnr_main.addPanel(pnl_title, PanelType.TITLE.toString());
		/*
		Container pnl_title = new TitlePanel(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				cardlayout.show(main_view,PanelType.MENU.toString());
			}
		});
		main_view.add(pnl_title,PanelType.TITLE.toString());
		*/
		contnr_main.addPanel(new HotPanel(),PanelType.HOT.toString());
		
		contnr_main.addPanel(new TeamPanel(),PanelType.TEAM.toString());
		
		contnr_main.showPanel(PanelType.TEAM.toString());

		
	}
	


}
