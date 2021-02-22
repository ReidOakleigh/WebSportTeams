package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SportsTeam;

public class SportsTeamHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeams"); 
	
	public void insertTeam(SportsTeam st) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(st);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<SportsTeam> showAllTeams(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<SportsTeam> resultList = (List<SportsTeam>) em.createQuery("SELECT st FROM SportsTeam st").getResultList();
		return resultList;
	}

	public SportsTeam deleteTeam(SportsTeam toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportsTeam> typedQuery = 
				em.createQuery("select st from SportsTeam st where st.city = :selectedcity and st.name = :selectedname", SportsTeam.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedcity", toDelete.getCity());
		typedQuery.setParameter("selectedname", toDelete.getName());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		SportsTeam result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		return result;
		
	}

	public void updateTeam(SportsTeam toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public SportsTeam searchForTeamById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SportsTeam found = em.find(SportsTeam.class, idToEdit);
		em.close();
		return found;
	}

	public List<SportsTeam> searchForTeamByCity(String city) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportsTeam> typedQuery = 
				em.createQuery("select st from SportsTeam st where st.city = :selectedcity", SportsTeam.class);
		typedQuery.setParameter("selectedcity", city);
		List<SportsTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}

	public List<SportsTeam> searchForTeamByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SportsTeam> typedQuery = 
				em.createQuery("select st from SportsTeam st where st.name = :selectedname", SportsTeam.class);
		typedQuery.setParameter("selectedname", name);
		List<SportsTeam> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public void cleanUp() {
		emfactory.close();
	}


}
