package fr.ironcrew.filmotheque.dal;

import java.util.List;

import fr.ironcrew.filmotheque.bo.Category;

public interface CategoryDAO {
	
	public void add(Category art);

	public void update(Category art);

	public void delete(Category art);

	public void delete(int id);
	
	public Category findById(int id);
	
	public List<Category> findAll();
}
