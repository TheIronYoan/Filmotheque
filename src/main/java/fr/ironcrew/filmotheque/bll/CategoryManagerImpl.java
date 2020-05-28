package fr.ironcrew.filmotheque.bll;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.ironcrew.filmotheque.bo.Category;
import fr.ironcrew.filmotheque.dal.CategoryDAO;

@Service
public class CategoryManagerImpl implements CategoryManager{

	@Autowired
	private CategoryDAO dao;
	
	
	public CategoryManagerImpl() {

	}
	
	

	public Category findById(  int id) throws CategoryNonTrouveException {
		Category art = dao.findById(id);
		if(art==null) {
			throw new CategoryNonTrouveException();
		}
		return art;
	}

	@Transactional
	public void saveCategory( Category art)  {
		if(art.getId()==0) {
			dao.add(art);
		}else {
			dao.update(art);
		}
	}

	@Transactional
	public void deleteCategory( Category id) throws CategoryNonTrouveException {
		
		dao.delete(id);
		
	}



	@Override
	public List<Category> findAllCategory() {
		return dao.findAll();
	}



}
