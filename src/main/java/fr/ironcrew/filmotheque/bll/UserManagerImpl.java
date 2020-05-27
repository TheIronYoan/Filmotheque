package fr.ironcrew.filmotheque.bll;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ironcrew.filmotheque.bo.Film;
import fr.ironcrew.filmotheque.bo.User;
import fr.ironcrew.filmotheque.dal.UserDAO;

@Service

public class UserManagerImpl implements UserManager{
	
	@Autowired
	private UserDAO dao;
	
	public UserManagerImpl() {

	}
	
	public User findById(  long id) {
		User user = dao.findById(id);
		return user;
	}
	
	public User authentification(String username,String password) {
		
		String passwordToTest = passwordHash(password);
		User testedUser = dao.findByUsername(username);
		
		if(passwordToTest.equals(testedUser.getPassword())){
			System.out.println("Auth OK");
			
		}
		else {
			testedUser.setUsername("inconnu");
			testedUser.setPassword("inconnu");
			}
		
		return testedUser;
	}
	
	@Transactional
	public void saveUser( User user)  {
		if(user.getId()==0) {
			dao.add(user);
		}else {
			dao.update(user);
		}
	}
	
	public String passwordHash(String password){
       	String passwordToHash = password ;
        String hashedPassword = null;
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(passwordToHash.getBytes());
           	            byte[] bytes = md.digest();
           
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
            
            hashedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return hashedPassword;
    }
}
