package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Category;

public interface CategoryManager {
	public Category findById(  int id) throws CategoryNonTrouveException ;

	public void saveCategory( Category film)  ;

	public void deleteCategory( Category id) throws CategoryNonTrouveException ;
	
	public List<Category> findAllCategory();
}
