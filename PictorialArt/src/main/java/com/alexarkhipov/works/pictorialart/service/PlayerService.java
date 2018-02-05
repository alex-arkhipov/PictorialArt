package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Players;

public interface PlayerService {
	List<Players> getPlayers();

	public void savePlayer(Players p);

	public Players getPlayer(String nickname);
}
