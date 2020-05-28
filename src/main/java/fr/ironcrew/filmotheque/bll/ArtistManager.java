package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Artist;

public interface ArtistManager {
	public Artist findById(int id) throws ArtistNonTrouveException ;

	public void saveArtist( Artist film)  ;

	public void deleteArtist( Artist id) throws ArtistNonTrouveException ;
	
	public List<Artist> findAllArtist();
	
	public List<Artist> findAllActors();
	
	public List<Artist> findAllDirectors();
}
