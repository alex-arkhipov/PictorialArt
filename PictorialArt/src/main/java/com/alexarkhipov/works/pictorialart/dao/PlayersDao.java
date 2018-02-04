package com.alexarkhipov.works.pictorialart.dao;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Players;

public interface PlayersDao {
	List<Players> getPlayers();

	void savePlayer(Players p);

	Players getPlayer(String Nickname);
}
