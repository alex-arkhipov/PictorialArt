package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.PlayerDao;
import com.alexarkhipov.works.pictorialart.model.Player;

@Component
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Player> getPlayers() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Player.class);
		return criteria.list();
	}

	public void savePlayer(Player p) {
		Session s = sessionFactory.openSession();
		s.save(p);
	}

	// @SuppressWarnings("unchecked")
	public Player getPlayer(String nickname) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Player.class);
		criteria.add(Restrictions.eq("nickname", nickname));
		return (Player) criteria.list().get(0);
	}

}
