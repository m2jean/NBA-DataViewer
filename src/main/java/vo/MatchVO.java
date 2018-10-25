package vo;

import helper.TypeTransform;

import java.util.ArrayList;
import java.util.Date;

import enums.Teams;
import enums.Terminology;
import exceptions.TermNotFound;

public class MatchVO {
	//
	Teams team1;
	Teams team2;
	String season;
	String date;
	String score;
	String score1;
	String score2;
	String score3;
	String score4;
	String scoreExtra;
	ArrayList<String> homeTeamPlayers;
	ArrayList<String> guestTeamPlayers;
	
	public MatchVO(String season, String date, Teams team1, Teams team2, String score, 
			String score1, String score2, String score3, String score4, String scoreExtra, 
			ArrayList<String> homeTeamPlayers, ArrayList<String> guestTeamPlayers){
		this.team1 = team1;
		this.team2 = team2;
		this.date = date;
		this.score = score;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.scoreExtra = scoreExtra;
		this.season = season;
		this.homeTeamPlayers = homeTeamPlayers;
		this.guestTeamPlayers = guestTeamPlayers;
	}

	public Teams getTeam1() {
		return team1;
	}

	public Teams getTeam2() {
		return team2;
	}
	
	public String getSeason() {
		return season;
	}
	
	public String getDate(){
		return date;
	}
	
	public Date getDay(){
		Date d = TypeTransform.str_to_date(date);
		return TypeTransform.addYear(d, season);
	}

	public String getScore() {
		return score;
	}

	public String getScore(int i) throws TermNotFound{
		switch(i){
		case 1:
			return score1;
		case 2:
			return score2;
		case 3:
			return score3;
		case 4:
			return score4;
		default:
			throw new TermNotFound(Terminology.PTS);
		}
	}
	
	public String getScore1() {
		return score1;
	}

	public String getScore2() {
		return score2;
	}

	public String getScore3() {
		return score3;
	}

	public String getScore4() {
		return score4;
	}
	
	public String getScoreExtra() {
		return scoreExtra;
	}

	public ArrayList<String> getHomeTeamPlayers() {
		return homeTeamPlayers;
	}

	public ArrayList<String> getGuestTeamPlayers() {
		return guestTeamPlayers;
	}

	public void print(){
		System.out.println(this.getDate() + "\n" +
				this.getTeam1() + "-" + this.getTeam2() + "\n" +
				this.getScore() + "\n" +
				this.getScore1() + ";" + this.getScore2() + ";" + 
				this.getScore3() + ";" + this.getScore4() + ";" + 
				this.getScoreExtra());
	}
	
}
