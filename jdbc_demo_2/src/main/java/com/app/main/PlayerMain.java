package com.app.main;

import java.util.List;

import com.app.dao.PlayerDAO;
import com.app.model.Player;
import com.app.dao.impl.PlayerDAOImpl;

public class PlayerMain   {

	public static void main(String[] args) {
	
		PlayerDAOImpl dao=new PlayerDAOImpl();
		Player player=new Player(110, "Jason", 24, "Los Angeles", "m", "Kings");
		int c= dao.createPlayer(player);
		if(c==1) {
			System.out.println("Player registerd with below details");
			System.out.println(player);
		}else {
			System.out.println("Failed registration");
		}
	}

}