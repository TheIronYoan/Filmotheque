package fr.ironcrew.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Film;

@Component
public class FilmDAOImpl implements FilmDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void add(Film film) {
		em.persist(film);
		
	}

	@Override
	public void update(Film film) {
		if(!em.contains(film)) {
			em.merge(film);
		}
		em.flush();
		
	}

	@Override
	public void delete(Film film) {
		if(!em.contains(film)) {
			em.merge(film);
		}
		em.remove(film);
		
	}

	@Override
	public List<Film> findAll() {
		return em.createQuery("select f from Film f", Film.class).getResultList();
	}

	@Override
	public Film findById(int id) {
		return em.find(Film.class, id);
	}

	@Override
	public void delete(int id) {
		Film film = findById(id);
		delete(film);
		
	}

}
