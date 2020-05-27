package fr.ironcrew.filmotheque.dal;

import java.util.List;

import fr.ironcrew.filmotheque.bo.Category;

public interface CategoryDAO {
	
	public void add(Category art);

	public void update(Category art);

	public void delete(Category art);

	public void delete(Long id);
	
	public Category findById(long id);
	
	public List<Category> findAll();
}
