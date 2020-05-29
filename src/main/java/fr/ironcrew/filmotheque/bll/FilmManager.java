package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Film;

public interface FilmManager {
	public Film findById(  int id) throws FilmNonTrouveException ;

	public void enregistrerFilm( Film film)  ;
	
	public void modifierFilm( Film film)  ;

	public void supprimerFilm( Film id) throws FilmNonTrouveException ;
	
	public List<Film> findAllFilms();
}
