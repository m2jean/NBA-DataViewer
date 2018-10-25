package data.playersData;

import java.util.ArrayList;
import po.PlayerPO;
import dataService.playersDataService.PlayersDataService;
import factory.ObjectCreator;
import exceptions.PlayerNotFound;

public class PlayersData implements PlayersDataService {
	ReadPlayers reader;
	
	static ArrayList<PlayerPO> playerList;
	
	public PlayersData(){
		reader = new ObjectCreator().playersReader();
		
		if(playerList == null){
			playerList = reader.readAllPlayers(null);
		}
	}

	@Override
	public PlayerPO getPlayer(String name) throws PlayerNotFound {
		for(int i=0; i<playerList.size(); i++){
			PlayerPO player = playerList.get(i);
			if(player.name().equals(name)){
				return player;
			}
		}
		
		throw new PlayerNotFound(name);
	}


	public ArrayList<PlayerPO> searchPlayer(String name) throws PlayerNotFound {
		ArrayList<PlayerPO> list = new ArrayList<PlayerPO>();
		for(int i=0; i<playerList.size(); i++){
			PlayerPO player = playerList.get(i);
			if(player.name().toLowerCase().contains(name.toLowerCase())){
				list.add(player);
			}
		}
		if(list.size() == 0)
			throw new PlayerNotFound(name);
		return list;
	}
	
	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		return playerList;
	}

}
