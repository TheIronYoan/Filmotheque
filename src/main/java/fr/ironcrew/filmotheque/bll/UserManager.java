package fr.ironcrew.filmotheque.bll;



import org.springframework.stereotype.Component;


import fr.ironcrew.filmotheque.bo.User;

@Component
public interface UserManager {
	public User findById(long id);
	
	public User authentification(String username,String password);
}
