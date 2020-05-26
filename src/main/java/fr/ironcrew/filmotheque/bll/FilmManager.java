package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Film;

public interface FilmManager {
	public Film findById(  long id) throws FilmNonTrouveException ;

	public void enregistrerFilm( Film film)  ;

	public void supprimerFilm( Film id) throws FilmNonTrouveException ;
	
	public List<Film> findAllFilms();
}
