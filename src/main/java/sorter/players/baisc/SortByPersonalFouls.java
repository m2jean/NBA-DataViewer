package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByPersonalFouls implements Comparator<PlayerBasicStatsVO> {

    @Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
        if(o1.getPersonalFouls() > o2.getPersonalFouls()){
            return 1;
        }else if(o1.getPersonalFouls() == o2.getPersonalFouls()){
            return 0;
        }else{
            return -1;
        }
    }

}