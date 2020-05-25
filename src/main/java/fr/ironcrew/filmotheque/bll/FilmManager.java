package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Film;

public interface FilmManager {
	public Film findById(  long id) throws FilmNonTrouveException ;

	public void enregistrerTodo( Film todo)  ;

	public void supprimerTodo( Film id) throws FilmNonTrouveException ;
	
	public List<Film> findAllTodos();
}
