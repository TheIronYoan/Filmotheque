package fr.ironcrew.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.User;

@Component
public class UserDAOImpl implements UserDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(User user) {
		em.persist(user);
		
	}

	@Override
	public void update(User user) {
		if(!em.contains(user)) {
			em.merge(user);
		}
		em.flush();
		
	}

	@Override
	public void delete(User user) {
		if(!em.contains(user)) {
			em.merge(user);
		}
		em.remove(user);
		
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("select f from users t", User.class).getResultList();
	}

	@Override
	public User findById(long id) {
		return em.find(User.class, id);
	}

	@Override
	public void delete(Long id) {
		User user = findById(id);
		delete(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return em.find(User.class, username);
	}

}
