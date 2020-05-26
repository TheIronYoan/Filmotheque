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
	// A remettre quand fichier modifié
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
	public void enregistrerTodo( Film todo)  {
		if(todo.getId()==0) {
			dao.add(todo);
		}else {
			dao.update(todo);
		}
	}

	@Transactional
	public void supprimerTodo( Long id) throws FilmNonTrouveException {
		
		dao.delete(id);
		
	}



	@Override
	public List<Film> findAllTodos() {
		return dao.findAll();
	}



	@Override
	public void supprimerTodo(Film id) throws FilmNonTrouveException {
		// TODO Auto-generated method stub
		
	}
}
