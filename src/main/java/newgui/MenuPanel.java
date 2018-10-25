package newgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;

import enums.PanelType;

public class MenuPanel extends WhitePanel {
	private static final long serialVersionUID = -3925773823220046063L;
	private HashMap<String,AbstractButton> btn_map = new HashMap<String,AbstractButton>(7);
	private ButtonGroup grp;


	public MenuPanel(int width, int height) {
		//this.setDoubleBuffered(false);
		this.setOpaque(false);
		//this.setLayout(null);

		String[] icons = new String[]{"players","teams","matches","stats","coaches","honors","hotspots"};
		String[] texts = new String[]{"球员","球队","比赛","数据","教练","荣誉","热点"};
		String[][] submenus = new String[][]{{"现役球员","历史球员"},{"现役球队","历史球队"},null,{"球员数据","球队数据"},null,null,null};
		String[][] actionCommands = new String[][]{{"",""},{"",""},{PanelType.MATCH.toString()},
				{PanelType.STATISTIC.toString()},{""},{""},{PanelType.HOT.toString()}};

		setSize(width,height);

		grp = new ButtonGroup();
		{
			final int btn_width = 161;
			final int btn_height = 60;
			final int btn_num = icons.length;
			final int hpad = (width-btn_width)/2;
			final int vgap = (height-btn_height*btn_num)/(btn_num+1);
			for(int i = 0, y = vgap;i < btn_num;i++, y += vgap+btn_height){
				MenuButton btn = new MenuButton("image/icon/button_"+icons[i]+".png",texts[i]);
				btn.setSize(btn_width, btn_height);
				btn.setLocation(hpad, y);
				btn.addItemListener(new ItemListener(){
					@Override
					public void itemStateChanged(ItemEvent e) {
						JToggleButton b = (JToggleButton)e.getSource();
						if(grp.getSelection() == null){
							b.setSelected(true);
						}
					}
				});
				this.add(btn);
				grp.add(btn);

				if(submenus[i] != null){
					final JPopupMenu popup = new JPopupMenu();
					popup.setLayout(new BoxLayout(popup,BoxLayout.X_AXIS));
					popup.setBorderPainted(false);
					popup.setBackground(new Color(230,230,255,255));
					//popup.setOpaque(false);
					for(int j = 0;j < submenus[i].length;j++){
						String s = submenus[i][j];
						JMenuItem item = new JMenuItem(s);
						item.setForeground(MainFrame.underscore_color);
						item.setBackground(new Color(230,230,255,0));
						item.setFont(new Font("黑体",Font.BOLD,20));
						item.setOpaque(false);
						popup.add(item);
						btn_map.put(s, item);
					}
					btn.addMouseListener(new MouseAdapter(){
						@Override
						public void mouseClicked(MouseEvent e) {
							JToggleButton b = (JToggleButton)e.getSource();
							popup.show(b,b.getWidth()+2,5);
						}
					});
				}
				else{
					btn.setActionCommand(actionCommands[i][0]);
					btn_map.put(texts[i], btn);
				}
			}
		}
	}


	public void addActionListenerAll(ActionListener al) {
		for(Entry<String,AbstractButton> e:btn_map.entrySet()){
			e.getValue().addActionListener(al);
		}
	}

}
