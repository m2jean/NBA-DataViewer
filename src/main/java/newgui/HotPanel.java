package newgui;

public class HotPanel extends WhitePanel {
	private static final long serialVersionUID = -1713103873633393406L;

	public HotPanel() {
		this.setLayout(null);
		
		final int left_line_1 = 20;
		final int left_line_2 = 460;
		final int top_line_1 = 26;
		final int height_1 = 40;
		final int width = 760;
		
		SubMenuPanel pnl_sub_1 = new SubMenuPanel(new String[]{"球员热点","球队热点"});
		pnl_sub_1.setBounds(left_line_1,top_line_1,210,height_1);
		add(pnl_sub_1);
		
		SubMenuPanel pnl_sub_2 = new SubMenuPanel(new String[]{"今日最佳","赛季最佳","进步最快"});
		pnl_sub_2.setBounds(left_line_2,top_line_1,width+left_line_1-left_line_2,height_1);
		add(pnl_sub_2);
		
		SubMenuPanel pnl_sub_3 = new SubMenuPanel(new String[]{"得分","篮板","助攻","盖帽","抢断","三分","投篮","罚球"});
		pnl_sub_3.setBounds(left_line_1,88,width,height_1);
		add(pnl_sub_3);
	}
}
