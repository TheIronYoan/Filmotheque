package fr.ironcrew.filmotheque.dal;

import java.util.List;

import fr.ironcrew.filmotheque.bo.User;

public interface UserDAO {
	
	public void add(User user);

	public void update(User user);

	public void delete(User user);

	public void delete(Long id);
	
	public User findById(long id);
	
	public List<User> findAll();

	public User findByUsername(String username);
}
