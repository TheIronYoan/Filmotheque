package fr.ironcrew.filmotheque.bll;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ironcrew.filmotheque.bo.User;
import fr.ironcrew.filmotheque.dal.UserDAO;

@Service
public class UserManagerImpl implements UserManager{
	// A remettre quand fichier modifié
	@Autowired
	private UserDAO dao;
	
	
	public UserManagerImpl() {

	}
	
	

	public User findById(  long id) {
		User user = dao.findById(id);
		return user;
	}

}
