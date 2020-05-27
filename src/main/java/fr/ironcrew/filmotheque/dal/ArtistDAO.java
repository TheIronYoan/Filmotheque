package fr.ironcrew.filmotheque.dal;

import java.util.List;

import fr.ironcrew.filmotheque.bo.Artist;

public interface ArtistDAO {
	
	public void add(Artist art);

	public void update(Artist art);

	public void delete(Artist art);

	public void delete(int id);
	
	public Artist findById(int id);
	
	public List<Artist> findAll();
	
	public List<Artist> findAllActors();
	
	public List<Artist> findAllDirectors();
}
