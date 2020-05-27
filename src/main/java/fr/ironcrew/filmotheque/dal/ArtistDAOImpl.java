package fr.ironcrew.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Artist;

@Component
public class ArtistDAOImpl implements ArtistDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Artist art) {
		em.persist(art);
		
	}

	@Override
	public void update(Artist art) {
		if(!em.contains(art)) {
			em.merge(art);
		}
		em.flush();
		
	}

	@Override
	public void delete(Artist art) {
		if(!em.contains(art)) {
			em.merge(art);
		}
		em.remove(art);
		
	}

	@Override
	public List<Artist> findAll() {
		return em.createQuery("select f from Artist f", Artist.class).getResultList();
	}

	@Override
	public Artist findById(long id) {
		return em.find(Artist.class, id);
	}

	@Override
	public void delete(Long id) {
		Artist art = findById(id);
		delete(art);
		
	}

}
