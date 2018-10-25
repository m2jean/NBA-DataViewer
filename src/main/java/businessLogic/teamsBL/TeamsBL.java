package businessLogic.teamsBL;

import java.util.ArrayList;

import po.TeamPO;
import vo.TeamDefensiveFoulsVO;
import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamRatioStatsVO;
import vo.TeamVO;
import dataService.teamsDataService.TeamsDataService;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import factory.TeamsCalculator;
import businessLogicService.matchesBLService.TeamDataInMatchesService;
import businessLogicService.teamsBLService.TeamInfoService;
import businessLogicService.teamsBLService.TeamsBLService;

public class TeamsBL implements TeamInfoService, TeamsBLService {
	//
	TeamsDataService teamsService;
	TeamDataInMatchesService matchesService;
	TeamsCalculator calculator;
	
	public TeamsBL(){
		teamsService = new ObjectCreator().teamsDataService();
		matchesService = new ObjectCreator().teamDataInMatchesService();
		calculator = new TeamsCalculator();
	}

	@Override
	public ArrayList<Teams> getTeams(Conference conference, Division division)
			throws TeamNotFound {
		ArrayList<TeamPO> list = teamsService.getTeams(conference, division);
		ArrayList<Teams> result = new ArrayList<Teams>();
		
		for(int i=0; i<list.size(); i++){
			result.add(list.get(i).name());
		}
		
		if(result.size() != 0){
			return result;
		}else{
			throw new TeamNotFound("");
		}
	}

	@Override
	public TeamVO getTeamInfo(Teams team) throws TeamNotFound {
		TeamPO po = teamsService.getTeam(team);
		Team team_bl = new Team(po);
		return team_bl.toVO();
	}
	
	public ArrayList<TeamVO> getAllTeamsInfo(){
		ArrayList<TeamPO> poList = teamsService.getAllTeams();
		ArrayList<TeamVO> voList = new ArrayList<TeamVO>();
		
		for(TeamPO po: poList){
			Team team_bl = new Team(po);
			voList.add(team_bl.toVO());
		}
		
		return voList;
	}
	
	private ArrayList<Teams> getTeamsName(Conference conference, Division division) throws TeamNotFound{
		return teamsService.getTeamsName(conference, division);
	}
	
	private TeamInMatches getTeamInMatches(Teams team) throws MatchNotFound, TeamNotFound{
		ArrayList<TeamStatsForCalculation> list = matchesService.getTeamDataForCalculation(team);
		ArrayList<BasicTeamStats> basic = matchesService.getBasicTeamStats(team);
		calculator = new TeamsCalculator(list);
		return new TeamInMatches(calculator.Sum(basic), calculator.calculate());
	}
	
	private TeamInMatches getTeamInMatches_basic(Teams team) throws TeamNotFound {
		ArrayList<BasicTeamStats> basic;
		try {
			basic = matchesService.getBasicTeamStats(team);
		} catch (TeamNotFound e) {
			throw new TeamNotFound("未找到该队伍参加的比赛");
		}
		
		return new TeamInMatches(calculator.Sum(basic), null);
	}

	@Override
	public ArrayList<TeamVO> getTeamsInfo(Conference conference,
			Division division) throws TeamNotFound {
		ArrayList<TeamPO> poList = teamsService.getTeams(conference, division);
		ArrayList<TeamVO> voList = new ArrayList<TeamVO>();
		for(TeamPO po: poList){
			Team team = new Team(po);
			voList.add(team.toVO());
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamGeneralStatsVO> getTeamsGeneralStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamGeneralStatsVO> result = new ArrayList<TeamGeneralStatsVO>();
		
		for(Teams team: teams){
			try {
				TeamInMatches match = this.getTeamInMatches(team);
				result.add(match.getGeneralStatsVO());
			} catch (MatchNotFound | TeamNotFound e) {
				continue;
			}	
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamOffensiveStatsVO> result = new ArrayList<TeamOffensiveStatsVO>();
		
		for(Teams team: teams){
			try{
				TeamInMatches match = this.getTeamInMatches_basic(team);
				result.add(match.getOffensiveStatsVO());
			}catch(TeamNotFound e){
				continue;
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamDefensiveStatsVO> result = new ArrayList<TeamDefensiveStatsVO>();
		
		for(Teams team: teams){
			try{
				TeamInMatches match = this.getTeamInMatches_basic(team);
				result.add(match.getDefensiveStatsVO());
			}catch(TeamNotFound e){
				continue;
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamFoulsStatsVO> result = new ArrayList<TeamFoulsStatsVO>();
		
		for(Teams team: teams){
			try{
				TeamInMatches match = this.getTeamInMatches_basic(team);
				result.add(match.getFoulsStatsVO());
			}catch(TeamNotFound e){
				continue;
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamRatioStatsVO> result = new ArrayList<TeamRatioStatsVO>();
		
		for(Teams team: teams){
			try{
				TeamInMatches match = this.getTeamInMatches_basic(team);
				result.add(match.getRatioStatsVO());
			}catch(TeamNotFound e){
				continue;
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamGeneralStatsVO> getTeamsGeneralStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		return this.getTeamsGeneralStatsTotal(conference, division);
	}

	@Override
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamOffensiveStatsVO> result = this.getTeamsOffensiveStatsTotal(conference, division);
		for(TeamOffensiveStatsVO team: result){
			team.average();
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamDefensiveStatsVO> result = this.getTeamsDefensiveStatsTotal(conference, division);
		for(TeamDefensiveStatsVO team: result){
			team.average();
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamFoulsStatsVO> result = this.getTeamsFoulsStatsTotal(conference, division);
		for(TeamFoulsStatsVO team: result){
			team.average();
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		return this.getTeamsRatioStatsTotal(conference, division);
	}

	@Override
	public TeamGeneralStatsVO getTeamStats(Teams team) {
		// TODO Auto-generated method stub
		// 暂时不用
		return null;
	}

	@Override
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamRatioGeneralVO> result = new ArrayList<TeamRatioGeneralVO>();
		
		for(Teams team: teams){
			try {
				TeamInMatches match = this.getTeamInMatches(team);
				result.add(match.getRatioGeneralVO());
			} catch (MatchNotFound | TeamNotFound e) {
				continue;
			}	
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teams = this.getTeamsName(conference, division);
		ArrayList<TeamDefensiveFoulsVO> result = new ArrayList<TeamDefensiveFoulsVO>();
		
		for(Teams team: teams){
			try{
				TeamInMatches match = this.getTeamInMatches_basic(team);
				result.add(match.getDefensiveFoulsVO());
			}catch(TeamNotFound e){
				continue;
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamRatioGeneralVO> result = this.getTeamRatioGeneralStatsTotal(conference, division);
		for(TeamRatioGeneralVO stats: result){
			stats.average();
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		return this.getTeamDefensiveFoulsStatsTotal(conference, division);
	}

}
