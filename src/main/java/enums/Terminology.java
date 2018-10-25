package enums;

public enum Terminology {
	//各种NBA中的专业术语
	NAME("名字"), TEAM("球队"),POSITION("位置"), GM("比赛场数"), GMSTR("先发场数"), MIN("在场时间"), 
	FGM("投篮命中数"), FGA("投篮出手数"), FGP("投篮命中率"), 
	TPM("三分命中数"), TPA("三分出手数"), TPP("三分命中率"), 
	FTM("罚球命中数"), FTA("罚球出手数"), FTP("罚球命中率"), 
	OREB("进攻篮板数"), DREB("防守篮板数"), REB("篮板数"), 
	AST("助攻数"), STL("抢断数"),  BLK("盖帽数"), 
	TOV("失误数"), PF("犯规数"), PTS("得分"), 
	PER("效率"), DBDB("两双数"), IMP("近五场提升率"), GMSC("GmSc"), 
	TSP("真实投篮命中率"), FGE("投篮效率"), 
	REBP("篮板率"), OREBP("进攻篮板率"), DREBP("防守篮板率"), 
	ASTP("助攻率"), STLP("抢断率"), BLKP("盖帽率"), TOVP("失误率"), 
	USGP("使用率"), 
	WINR("胜率"), 
	OFR("进攻回合"), DFR("防守回合"), 
	OFE("进攻效率"), DFE("防守效率"), 
	OREBDE("进攻篮板效率"), DREBDE("防守篮板效率"), 
	STLE("抢断效率"), ASTE("助攻效率"),
	
	ATTENDED("参赛场数"),PREMIERE("先发场数"),GMWIN("获胜场数");
	
	String terminology;
	
	private Terminology(String s){
		this.terminology = s;
	}
	
	public String toString(){
		return terminology;
	}
	
	public static Terminology toEnum_player(String term) {
		switch(term){
		case "score": return PTS;
		case "point": return PTS;
		case "rebound": return REB;
		case "assist": return AST;
		case "blockShot": return BLK;
		case "steal": return STL;
		case "foul": return PF;
		case "fault": return TOV;
		case "minute": return MIN;
		case "efficient": return PER;
		case "shot": return FGP;
		case "three": return TPP;
		case "penalty": return FTP;
		case "doubleTwo": return DBDB;
		case "realShot": return TSP;
		case "GmSc": return GMSC;
		case "shotEfficient": return FGE;
		case "reboundEfficient": return REBP;
		case "defendReboundEfficient": return DREB;
		case "offendReboundEfficient": return OREB;
		case "assistEfficient": return ASTE;
		case "stealEfficient": return STLE;
		case "blockShotEfficient": return BLKP;
		case "faultEfficient": return TOVP;
		case "frequency": return USGP;
		default: return null;
		}
	}
	
	public static Terminology toEnum_team(String term) {
		switch(term){
		case "score": return PTS;
		case "point": return PTS;
		case "rebound": return REB;
		case "assist": return AST;
		case "blockShot": return BLK;
		case "steal": return STL;
		case "foul": return PF;
		case "fault": return TOV;
		case "shot": return FGP;
		case "three": return TPP;
		case "penalty": return FTP;
		case "defendRebound": return DREB;
		case "offendRebound": return OREB;
		case "winRate": return WINR;
		case "offendRound": return OFR;
		case "offendEfficient": return OFE;
		case "defendEfficient": return DFE;
		case "offendReboundEfficient": return OREBDE;
		case "defendReboundEfficient": return DREBDE;
		case "stealEfficient": return STLE;
		case "assistEfficient": return ASTE;
		default: return null;
		}
	}
	
	static public Terminology[] getPlayerSeasonBasic(){
		//参赛场数、先发场数、篮板数、助攻数、在场时间、投篮命中率、三分命中率、罚球命中率、进攻数、防守数、抢断数、盖帽数、犯规数、失误数、得分
		return new Terminology[]{ATTENDED,PREMIERE,MIN,PTS,FGP,TPP,FTP,REB,AST,OFR,DFR,STL,BLK,TOV,PF};
	}
	static public Terminology[] getPlayerMatchBasic(){
		//队伍、位置、得分、投篮命中数、三分命中数、罚球命中数、篮板数、助攻数、在场时间、投篮命中率、三分命中率、罚球命中率、进攻数、防守数、抢断数、盖帽数、犯规数、失误数、
		return new Terminology[]{TEAM,POSITION,MIN,PTS,FGM,TPM,FTM,FGP,TPP,FTP,REB,AST,OFR,DFR,STL,BLK,TOV,PF};
	}
	
	static public Terminology[] getPlayerCompareBasic(){
		//得分、投篮命中数、三分命中数、罚球命中数、篮板数、助攻数、在场时间、投篮命中率、三分命中率、罚球命中率、进攻数、防守数、抢断数、盖帽数、犯规数、失误数、
		return new Terminology[]{MIN,PTS,FGM,TPM,FTM,FGP,TPP,FTP,REB,AST,OFR,DFR,STL,BLK,TOV,PF};
	}

	static public Terminology[] getPlayerAdvanced(){
		//效率、GmSc效率值、真实命中率、投篮效率、篮板率、进攻篮板率、防守篮板率、助攻率、抢断率、盖帽率、失误率、使用率
		return new Terminology[]{PER,GMSC,TSP,FGE,REBP,OREBP,DREBP,ASTP,STLP,BLKP,TOVP,USGP};
	}
	
	
	static public Terminology[] getPlayerSeasonHot(){
		//场均得分，场均篮板，场均助攻，场均盖帽，场均抢断，三分命中率，投篮命中率，罚球命中率
		return new Terminology[]{PTS,REB,AST,BLK,STL,TPP,FGP,FTP};
	}
	
	static public Terminology[] getTeamHot(){
		//场均得分，场均篮板，场均助攻，场均盖帽，场均抢断，三分命中率，投篮命中率，罚球命中率
		return new Terminology[]{PTS,REB,AST,BLK,STL,TPP,FGP,FTP};
	}
	
	static public Terminology[] getPlayerTodayHot(){
		//得分，篮板，助攻，盖帽，抢断
		return new Terminology[]{PTS,REB,AST,BLK,STL};
	}
	
	static public Terminology[] getPlayerProgress(){
		//场均得分，场均篮板，场均助攻
		return new Terminology[]{PTS,REB,AST};
	}
	
	static public Terminology[] getTeamOffensive(){
		return new Terminology[]{PTS,FGM,FGA,FTM,FTA,TPM,TPA,AST};
	}
	
	static public Terminology[] getTeamDefensive(){
		return new Terminology[]{OREB,DREB,REB,STL,BLK};
	}
	
	static public Terminology[] getTeamFouls(){
		return new Terminology[]{TOV,PF};
	}
	
	static public Terminology[] getTeamRatio(){
		return new Terminology[]{FGP,FTP,TPP};
	}
	
	static public Terminology[] getTeamGeneral(){
		return new Terminology[]{OFR,OFE,DFE,OREBDE,DREBDE,STLE,ASTE};
	}
	
	static public String getUnit(Terminology term){
		switch(term){
		case ASTP:
		case BLKP:
		case DREBP:
		case FGP:
		case FTP:
		case GMSC:
		case IMP:
		case OREBP:
		case PER:
		case REBP:
		case STLP:
		case TOVP:
		case TPP:
		case TSP:
		case USGP:
		case WINR:
			return "%";
		default:
			return "";
		
		}
	}
	
}
