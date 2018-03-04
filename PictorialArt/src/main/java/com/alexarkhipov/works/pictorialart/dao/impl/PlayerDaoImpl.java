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
		List<Player> l = null;
		try (Session s = sessionFactory.openSession()) {		
			Criteria criteria = s.createCriteria(Player.class);
			l = criteria.list();
		}
		return l;
	}

	public void savePlayer(Player p) {
		try (Session s = sessionFactory.openSession()) {
			s.save(p);	
		}
	}

	public Player getPlayer(String nickname) {
		Player p = null;
		try (Session s = sessionFactory.openSession()) {
			Criteria criteria = s.createCriteria(Player.class);
			criteria.add(Restrictions.eq("nickname", nickname));
			p = (Player) criteria.list().get(0);
		}
		return p;
	}

}
