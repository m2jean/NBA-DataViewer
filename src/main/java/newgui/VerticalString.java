package newgui;

public class VerticalString {

	private VerticalString() {
		
	}

	public static String formVerticalString(String s){
		CharSequence chars = s.subSequence(0, s.length());
		StringBuffer str = new StringBuffer("<html>"+chars.charAt(0));
		for(int i = 1;i < chars.length();i++){
			str.append("<br/><br/>");
			str.append(chars.charAt(i));
		}
		str.append("<html/>");
		return str.toString();
	}
}
