package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;


public class PlayerHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueBarber");
	public void insertPlayer(Player toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deletePlayer(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player find = em.find(Player.class, toDelete.getPlayerId());
		em.remove(find);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> viewAllPlayers() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select p from Player p", Player.class);
		List<Player> allPlayers = allResults.getResultList();
		em.close();
		return allPlayers;
	}
	
}

