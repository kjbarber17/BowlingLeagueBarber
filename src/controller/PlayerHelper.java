package controller;

import java.util.List;

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
	public void deleteAllPlayersOnTeam(Team team) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> deletePlayers = em.createQuery("delete from Player p where p.team = :selectedTeam", Player.class);
		deletePlayers.setParameter("selectedTeam",team);
		int deleteCount = deletePlayers.executeUpdate();
		if (deleteCount > 0 ) {
			System.out.println("players removed");
		}
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
	public Player searchForPlayerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player foundPlayer = em.find(Player.class, idToEdit);
		em.close();
		return foundPlayer;
	}
	public void deletePlayer(Player player) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> deletePlayer = em.createQuery("select p from Player p where p.playerId = :selectedId", Player.class);
		deletePlayer.setParameter("selectedId", player.getPlayerId());
		deletePlayer.setMaxResults(1);
		Player toDelete = deletePlayer.getSingleResult();
		em.remove(toDelete);
		em.getTransaction().commit();
		em.close();
	}

}



