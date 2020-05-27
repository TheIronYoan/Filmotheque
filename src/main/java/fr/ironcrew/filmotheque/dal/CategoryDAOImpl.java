package fr.ironcrew.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Category;

@Component
public class CategoryDAOImpl implements CategoryDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Category art) {
		em.persist(art);
		
	}

	@Override
	public void update(Category art) {
		if(!em.contains(art)) {
			em.merge(art);
		}
		em.flush();
		
	}

	@Override
	public void delete(Category art) {
		if(!em.contains(art)) {
			em.merge(art);
		}
		em.remove(art);
		
	}

	@Override
	public List<Category> findAll() {
		return em.createQuery("select f from Artist f", Category.class).getResultList();
	}

	@Override
	public Category findById(long id) {
		return em.find(Category.class, id);
	}

	@Override
	public void delete(Long id) {
		Category art = findById(id);
		delete(art);
		
	}

}
