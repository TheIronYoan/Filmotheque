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
	
	

	public Film findById(  long id) throws FilmNonTrouveException {
		Film film = dao.findById(id);
		if(film==null) {
			throw new FilmNonTrouveException();
		}
		return film;
	}

	@Transactional
	public void enregistrerFilm( Film todo)  {
		if(todo.getId()==0) {
			dao.add(todo);
		}else {
			dao.update(todo);
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

}
