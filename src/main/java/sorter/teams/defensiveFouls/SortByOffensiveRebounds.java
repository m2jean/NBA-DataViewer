package sorter.teams.defensiveFouls;

import java.util.Comparator;

import vo.TeamDefensiveFoulsVO;

public class SortByOffensiveRebounds implements Comparator<TeamDefensiveFoulsVO> {

    @Override
    public int compare(TeamDefensiveFoulsVO o1, TeamDefensiveFoulsVO o2) {
        if(o1.getOffensiveRebounds() > o2.getOffensiveRebounds()){
            return 1;
        }else if(o1.getOffensiveRebounds() == o2.getOffensiveRebounds()){
            return 0;
        }else{
            return -1;
        }
    }
}
