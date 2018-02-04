package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.PlayersDao;
import com.alexarkhipov.works.pictorialart.model.Players;

@Component
public class PlayersDaoImpl implements PlayersDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Players> getPlayers() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Players.class);
		return criteria.list();
	}

	public void savePlayer(Players p) {
		Session s = sessionFactory.openSession();
		s.save(p);
	}

	// @SuppressWarnings("unchecked")
	public Players getPlayer(String nickname) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Players.class);
		criteria.add(Restrictions.eq("nickname", nickname));
		return (Players) criteria.list().get(0);
	}

}
