package com.app.dao;

import com.app.model.Player;
import java.util.List;

public interface PlayerDAO {

	public int createPlayer(Player player) ;
	
	public List<Player> getAllPlayers();
	
	public boolean updatePlayer(Player player);
	
	public boolean deletePlayerById(int Id);
}
