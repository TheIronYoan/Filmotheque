package fr.ironcrew.filmotheque.dal;

import java.util.List;

import fr.ironcrew.filmotheque.bo.Film;

public interface FilmDAO {
	
	public void add(Film film);

	public void update(Film film);

	public void delete(Film film);

	public void delete(int id);
	
	public Film findById(int id);
	
	public List<Film> findAll();
}
