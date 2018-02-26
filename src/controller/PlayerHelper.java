package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;
import model.Team;


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
	
	public Team searchForTeamByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("select t from Team t where t.teamName = :selectedTeamName", Team.class);
		typedQuery.setParameter("selectedTeamName", name);
		typedQuery.setMaxResults(1);
		Team result = typedQuery.getSingleResult();
		em.close();
		return result;
	}
}

