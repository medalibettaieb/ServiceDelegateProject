package edu.app.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.app.persistence.User;

@Stateless
public class UserService implements UserServiceRemote {
	
	@PersistenceContext( unitName = "PU")
	private EntityManager em;

    public UserService() {
    }

	public void create(User user) {
		em.persist(user);
	}

	public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:p1 and u.password=:p2";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", login);
		query.setParameter("p2", password);
		try{
			found = (User) query.getSingleResult();
		}catch(Exception e){
		}
		
		return found;
	}

}
