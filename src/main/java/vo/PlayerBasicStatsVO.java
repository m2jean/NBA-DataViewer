package vo;

import javax.swing.ImageIcon;

import gui.util.GUIUtility;
import helper.TypeTransform;
import businessLogic.playersBL.BasicPlayerStats;
import enums.Position;
import enums.Teams;
import enums.Terminology;
import exceptions.TermNotFound;

public class PlayerBasicStatsVO implements StatsVO{
	//
	String name;                                     //姓名
	Teams team;                                      //所属球队
	Position position;                               //位置
	double games;                                    //参赛场数
	double gamesStarting;                            //先发场数
	String minutes;                                  //在场时间
	double rebounds;                                 //篮板数
	double assists;                                  //助攻数
	double fieldGoalPercentage;                      //命中率
	double threePointFieldGoalPercentage;            //三分命中率
	double freeThrowPercentage;                      //罚球命中率
	double offensiveRebounds;                        //进攻（篮板）数
	double defensiveRebounds;                        //防守(篮板)数
	double steals;                                   //抢断数
	double blocks;                                   //盖帽数
	double turnovers;                                //失误数
	double personalFouls;                              //犯规数
	double points;                                   //个人得分
	double doubleDoubles;                            //两双数
	ImageIcon portrait;                             //头像
	
	double fieldGoalsMade;                           //两分球
	double fieldGoalsAttempted;
	double threePointFieldGoalsMade;                //三分球
	double threePointFieldGoalsAttempted;
	double freeThrowsMade;                          //罚球
	double freeThrowsAttempted;
	
	public PlayerBasicStatsVO(BasicPlayerStats stats){
		this.name = stats.name();
		this.team = stats.team();
		this.games = stats.games();
		this.gamesStarting = stats.gamesStarting();
		this.minutes = TypeTransform.minutes_to_str(stats.minutes());
		this.rebounds = stats.rebounds();
		this.assists = stats.assists();
		if(stats.fieldGoalsAttempted() < 0.001){
			this.fieldGoalPercentage = 0;
		}else{
			this.fieldGoalPercentage = stats.fieldGoalsMade()/stats.fieldGoalsAttempted();
		}
		if(stats.threePointFieldGoalsAttempted() < 0.001){
			this.threePointFieldGoalPercentage = 0;
		}else{
			this.threePointFieldGoalPercentage = stats.threePointFieldGoalsMade()/stats.threePointFieldGoalsAttempted();
		}
		if(stats.freeThrowsAttempted() < 0.001){
			this.freeThrowPercentage = 0;
		}else{
			this.freeThrowPercentage = stats.freeThrowsMade()/stats.freeThrowsAttempted();
		}
		this.offensiveRebounds = stats.offensiveRebounds();
		this.defensiveRebounds = stats.defensiveRebounds();
		this.steals = stats.steals();
		this.blocks = stats.blocks();
		this.turnovers = stats.turnovers();
		this.personalFouls = stats.personalFouls();
		this.points = stats.points();
	}
	
	public PlayerBasicStatsVO(String name, Teams team, Position position, double games, double gamesStarting, 
			String minutes, double rebounds, double ast,double or, double dr, double stl, 
			double blk, double tov, double fouls, double pts, double dd, double fgm, double fga, 
			double tpm, double tpa, double ftm, double fta){
		this.name = name;
		this.team = team;
		this.position = position;
		this.games = games;
		this.gamesStarting = gamesStarting;
		this.minutes = minutes;
		this.rebounds = rebounds;
		this.assists = ast;
		this.offensiveRebounds = or;
		this.defensiveRebounds = dr;
		this.steals = stl;
		this.blocks = blk;
		this.turnovers = tov;
		this.personalFouls = fouls;
		this.points = pts;
		this.doubleDoubles = dd;
		
		this.fieldGoalsMade = fgm;
		this.fieldGoalsAttempted = fga;
		this.threePointFieldGoalsMade = tpm;
		this.threePointFieldGoalsAttempted = tpa;
		this.freeThrowsMade = ftm;
		this.freeThrowsAttempted = fta;
		
		if(this.fieldGoalsAttempted > 0.001){
			this.fieldGoalPercentage = this.fieldGoalsMade/this.fieldGoalsAttempted;
		}else{
			this.fieldGoalPercentage = 0;
		}
		
		if(this.threePointFieldGoalsAttempted > 0.001){
			this.threePointFieldGoalPercentage = this.threePointFieldGoalsMade/this.threePointFieldGoalsAttempted;
		}else{
			this.threePointFieldGoalPercentage = 0;
		}
		
		if(this.freeThrowsAttempted > 0.001){
			this.freeThrowPercentage = this.freeThrowsMade/this.freeThrowsAttempted;
		}else{
			this.freeThrowPercentage = 0;
		}
	}
	
	public double getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public double getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}

	public double getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}

	public double getThreePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}

	public double getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public double getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public void average(){
		double min = TypeTransform.str_to_minutes(minutes);
		this.minutes = TypeTransform.minutes_to_str(min/games);
		this.rebounds /= games;
		this.assists /= games;
		this.offensiveRebounds /= games;
		this.defensiveRebounds /= games;
		this.steals /= games;
		this.blocks /= games;
		this.turnovers /= games;
		this.personalFouls /= games;
		this.points /= games;
		this.doubleDoubles /= games;
		this.fieldGoalsMade /= games;
		this.fieldGoalsAttempted /= games;
		this.threePointFieldGoalsMade /= games;
		this.threePointFieldGoalsAttempted /= games;
		this.freeThrowsMade /= games;
		this.freeThrowsAttempted /= games;
	}
	
	public void addPortrait(ImageIcon image){
		this.portrait = image;
	}
	
	public ImageIcon getPortrait(){
		return portrait;
	}

	public String getName() {
		return name;
	}

	public Teams getTeam() {
		return team;
	}
	
	public Position getPosition(){
		return position;
	}

	public double getGames() {
		return games;
	}

	public double getGamesStarting() {
		return gamesStarting;
	}

	public double getRebounds() {
		return rebounds;
	}

	public double getAssists() {
		return assists;
	}

	public String getMinutes() {
		return minutes;
	}

	public double getFieldGoalPercentage() {
		return fieldGoalPercentage*100;
	}

	public double getThreePointFieldGoalPercentage() {
		return threePointFieldGoalPercentage*100;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage*100;
	}

	public double getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public double getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public double getSteals() {
		return steals;
	}

	public double getBlocks() {
		return blocks;
	}

	public double getTurnovers() {
		return turnovers;
	}

	public double getPersonalFouls() {
		return personalFouls;
	}

	public double getPoints() {
		return points;
	}
	
	public double getDoubleDoubles() {
		return doubleDoubles;
	}
	
	public double getEfficiency() {
		return points + rebounds + assists + steals + blocks - this.fieldGoalsAttempted
				+ this.fieldGoalsMade - this.threePointFieldGoalsAttempted
				+ this.threePointFieldGoalsMade - this.freeThrowsAttempted
				+ this.freeThrowsAttempted;
	}
	
	public String getProperty(Terminology term) throws TermNotFound{
		switch(term){
		case ATTENDED:
			return GUIUtility.formatDouble(this.games);
		case PREMIERE:
			return GUIUtility.formatDouble(this.gamesStarting);
		case REB:
			return GUIUtility.formatDouble(this.getRebounds());
		case AST:
			return GUIUtility.formatDouble(this.getAssists());
		case MIN:
			return minutes;
		case FGP:
			return GUIUtility.formatDouble(this.getFieldGoalPercentage());
		case TPP:
			return GUIUtility.formatDouble(this.getThreePointFieldGoalPercentage());
		case FTP:
			return GUIUtility.formatDouble(this.getFreeThrowPercentage());
		case OFR:
			return GUIUtility.formatDouble(this.getOffensiveRebounds());
		case DFR:
			return GUIUtility.formatDouble(this.getDefensiveRebounds());
		case TOV:
			return GUIUtility.formatDouble(this.getTurnovers());
		case STL:
			return GUIUtility.formatDouble(this.getSteals());
		case BLK:
			return GUIUtility.formatDouble(this.getBlocks());
		case PF:
			return GUIUtility.formatDouble(this.getPersonalFouls());
		case PTS:
			return GUIUtility.formatDouble(this.getPoints());
		case FGM:
			return GUIUtility.formatDouble(this.getFieldGoalsMade());
		case TPM:
			return GUIUtility.formatDouble(this.getThreePointFieldGoalsMade());
		case FTM:
			return GUIUtility.formatDouble(this.getFreeThrowsMade());
		case POSITION:
			return this.getPosition().toString();
		case TEAM:
			return this.getTeam().toString();
		default:
			throw new TermNotFound(term);
		}
	}
	
	public void print(){
		System.out.println(this.name + "\n" + 
		this.team + "\n" + 
		this.games + "\n" + 
		this.gamesStarting + "\n" + 
		this.minutes + "\n" + 
		this.rebounds + "\n" + 
		this.assists + "\n" + 
		this.fieldGoalPercentage + "\n" + 
		this.threePointFieldGoalPercentage + "\n" + 
		this.freeThrowPercentage + "\n" + 
		this.offensiveRebounds + "\n" + 
		this.defensiveRebounds + "\n" + 
		this.steals + "\n" + 
		this.blocks + "\n" + 
		this.turnovers + "\n" + 
		this.personalFouls + "\n" + 
		this.points);
	}
	
}
