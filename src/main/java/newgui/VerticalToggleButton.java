package newgui;

import javax.swing.JToggleButton;

public class VerticalToggleButton extends JToggleButton {
	private static final long serialVersionUID = 3193461550242218787L;
	private String origin_text;

	public VerticalToggleButton(String s) {
		super(VerticalString.formVerticalString(s));
		
		origin_text = s;
	}

	public String getOriginalText(){
		return origin_text;
	}
	

	public void setOriginalText(String s){
		origin_text = s;
		super.setText(VerticalString.formVerticalString(s));
	}
}
