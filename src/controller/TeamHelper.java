package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueBarber");
	public void insertTeam(Team t) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteTeam(Team team) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> deleteTeam = em.createQuery("select t from Team t where t.teamId = :selectedId", Team.class);
		deleteTeam.setParameter("selectedId", team.getTeamId());
		deleteTeam.setMaxResults(1); 
		Team toDelete = deleteTeam.getSingleResult();
		em.remove (toDelete);
		em.getTransaction().commit();
		em.close();
	}

	public Team searchForTeamByName(String teamName) {

		try {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Team> findTeam = em.createQuery("select t from Team t where t.teamName = :selectedTeamName", Team.class);
			findTeam.setParameter("selectedTeamName", teamName);
			findTeam.setMaxResults(1);
			Team foundteam = findTeam.getSingleResult();
			em.close();
			return foundteam;
		}
		catch (NoResultException e) {
			return null;
		}
	}
	public List<Team> viewAllTeams() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Team> allResults = em.createQuery("select t from Team t", Team.class);
		List<Team> allTeams = allResults.getResultList();
		em.close();
		return allTeams;
	}
	public Team searchForTeamById(int teamId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		Team foundTeam = em.find(Team.class, teamId);
		em.close();
		return foundTeam;
	}
	public void updateTeam(Team toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}