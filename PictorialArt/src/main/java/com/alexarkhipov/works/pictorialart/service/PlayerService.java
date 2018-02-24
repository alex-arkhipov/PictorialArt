package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Player;

public interface PlayerService {
	List<Player> getPlayers();

	public void savePlayer(Player p);

	public Player getPlayer(String nickname);
}
