package com.alexarkhipov.works.pictorialart.dao;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Player;

public interface PlayerDao {
	List<Player> getPlayers();

	void savePlayer(Player p);

	Player getPlayer(String nickname);
}
