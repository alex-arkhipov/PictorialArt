package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.PlayerDao;
import com.alexarkhipov.works.pictorialart.model.Player;
import com.alexarkhipov.works.pictorialart.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;

	public List<Player> getPlayers() {
		return playerDao.getPlayers();
	}

	public void savePlayer(Player p) {
		playerDao.savePlayer(p);
	}

	public Player getPlayer(String nickname) {
		return playerDao.getPlayer(nickname);
	}

}
