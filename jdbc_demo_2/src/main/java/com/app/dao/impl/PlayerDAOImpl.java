package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.PlayerDAO;
import com.app.dbutil.PostgresConnection;
import com.app.model.Player;


public class PlayerDAOImpl implements PlayerDAO {
	@Override
	public int createPlayer(Player player) {
		int c=0;
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="insert into player(id,name,age,city,gender,team) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setInt(3, player.getAge());
			preparedStatement.setString(4, player.getCity());
			preparedStatement.setString(5, player.getGender());
			preparedStatement.setString(6, player.getTeam());
			
			c=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return c;
	}

	@Override
	public List<Player> getAllPlayers() {
		List<Player> playersList=new ArrayList<>();
		try(Connection connection=PostgresConnection.getConnection()){
			String sql="select id,name,age,city,gender,team from player";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Player player=new Player();
				player.setId(resultSet.getInt("id"));
				player.setAge(resultSet.getInt("age"));
				player.setName(resultSet.getString("name"));
				player.setGender(resultSet.getString("gender"));
				player.setTeam(resultSet.getString("team"));
				player.setCity(resultSet.getString("city"));
				playersList.add(player);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		return playersList;
	}

	@Override
	public boolean updatePlayer(Player player) {
		int c = 0;
		try (Connection connection=PostgresConnection.getConnection()){
			String sql="UPDATE player SET city=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, player.getCity());
			preparedStatement.setInt(2, player.getId());
			
			c=preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}

	@Override
	public boolean deletePlayerById(int Id) {
		try (Connection connection=PostgresConnection.getConnection()){
		String sql="delete from player where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
	 	preparedStatement.setInt(1, Id);
	
	 	if (preparedStatement.executeUpdate() != 0)
			return true;
		else
			return false;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}}