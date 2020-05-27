package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Artist;

public interface ArtistManager {
	public Artist findById(  long id) throws ArtistNonTrouveException ;

	public void enregistrerArtist( Artist film)  ;

	public void supprimerArtist( Artist id) throws ArtistNonTrouveException ;
	
	public List<Artist> findAllArtist();
}
