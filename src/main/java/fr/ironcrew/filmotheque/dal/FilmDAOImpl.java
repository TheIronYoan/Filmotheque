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
		em.flush();
		
	}

	@Override
	public void update(Film film) {
		//if(!em.contains(film)) {
			em.merge(film);
		//}
		em.flush();
		
	}

	@Override
	public void delete(Film film) {
		if(!em.contains(film)) {
			em.merge(film);
		}
		em.remove(em.contains(film) ? film : em.merge(film));
		
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

	@Override
	public List<Film> findFilmWithParam(String name, int cat, int minYear, int maxYear, int real, int act) {
		String query="select f from Film f left join f.actors a ";
		if(name.length()>0||cat>0||minYear>0||maxYear>0||real>0||act>0) {
			query+="where ";
		}
		if(name.length()>0) {
			query+="f.name LIKE '%"+name+"%' AND ";
		}
		if(cat>0) {
			query+="f.category="+cat+" AND ";
		}
		
		if(minYear>0) {
			query+="f.releaseDate>"+minYear+" AND ";
		}
		
		if(maxYear>0) {
			query+="f.releaseDate<"+maxYear+" AND ";
		}
		
		if(real>0) {
			query+="f.director = '"+real+"' AND ";
		}
		
		if(act>0) {
			query+="a.id = "+act+" AND ";
		}
		
		
		query=query.substring(0, query.length() - 4);
		return em.createQuery(query, Film.class).getResultList();
				
				
		
	}

}
