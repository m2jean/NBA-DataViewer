package newgui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainContainer extends Container {
	private static final long serialVersionUID = -311065542322641285L;
	private CardLayout cardlayout = new CardLayout();
	private Container contnr = new Container();

	MainContainer(){
		setLayout(null);
		
		final int top_line = 25;
		final int height = 615;
		
		MenuPanel pnl = new MenuPanel(155,height);
		pnl.setLocation(20, top_line);
		pnl.addActionListenerAll(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(contnr, e.getActionCommand());
			}
		});
		add(pnl);
		
		contnr.setBounds(190, top_line, 810, height);
		contnr.setLayout(cardlayout);
		add(contnr);

	}
	
	public void addPanel(Container pnl,String constraint){
		contnr.add(pnl, constraint);
	}

	public void showPanel(String constraint){
		cardlayout.show(contnr, constraint);
	}
}
