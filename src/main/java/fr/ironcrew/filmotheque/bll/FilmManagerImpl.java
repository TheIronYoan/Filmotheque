package fr.ironcrew.filmotheque.bll;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.ironcrew.filmotheque.bo.Film;
import fr.ironcrew.filmotheque.dal.FilmDAO;

@Service
public class FilmManagerImpl implements FilmManager{

	@Autowired
	private FilmDAO dao;
	
	
	public FilmManagerImpl() {

	}
	
	public Film findById(  int id) throws FilmNonTrouveException {
		Film film = dao.findById(id);
		if(film==null) {
			throw new FilmNonTrouveException();
		}
		return film;
	}

	@Transactional
	public void enregistrerFilm( Film film)  {
		if(film.getId()==0) {
			dao.add(film);
		}else {
			dao.update(film);
		}
	}

	@Transactional
	public void supprimerFilm( Film id) throws FilmNonTrouveException {
		
		dao.delete(id);
		
	}



	@Override
	public List<Film> findAllFilms() {
		return dao.findAll();
	}

	
	@Transactional
	public void modifierFilm(Film film) {
		System.out.println(film.getId()+"+ c'est l'od");
			if(film.getId()==0) {
				dao.add(film);
			}else {
				dao.update(film);
			}
		
	}

	@Override
	public List<Film> rechercheFilm(String name, int cat, int minYear, int maxYear, int real, int act) {
		return dao.findFilmWithParam(name, cat, minYear, maxYear, real, act);
		
	}

}
