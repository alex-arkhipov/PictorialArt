package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.PlayerDao;
import com.alexarkhipov.works.pictorialart.model.Players;
import com.alexarkhipov.works.pictorialart.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playersDao;

	public List<Players> getPlayers() {
		return playersDao.getPlayers();
	}

	public void savePlayer(Players p) {
		playersDao.savePlayer(p);
	}

	public Players getPlayer(String nickname) {
		return playersDao.getPlayer(nickname);
	}

}
