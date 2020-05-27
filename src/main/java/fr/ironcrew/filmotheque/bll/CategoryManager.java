package fr.ironcrew.filmotheque.bll;


import java.util.List;

import org.springframework.stereotype.Component;

import fr.ironcrew.filmotheque.bo.Category;

public interface CategoryManager {
	public Category findById(  long id) throws CategoryNonTrouveException ;

	public void enregistrerCategory( Category film)  ;

	public void supprimerCategory( Category id) throws CategoryNonTrouveException ;
	
	public List<Category> findAllCategory();
}
