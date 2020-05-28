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
	public Artist findById(int id) {
		return em.find(Artist.class, id);
	}

	@Override
	public void delete(int id) {
		Artist art = findById(id);
		delete(em.contains(art) ? art : em.merge(art));
		
	}

	@Override
	public List<Artist> findAllActors() {
		return em.createQuery("select f from Artist f where f.actor=1", Artist.class).getResultList();
	}

	@Override
	public List<Artist> findAllDirectors() {
		return em.createQuery("select f from Artist f where f.director=1", Artist.class).getResultList();
	}

}
