package fr.ironcrew.filmotheque.bll;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		User testedUser = dao.findByUsername(username);
		
		
		
		return testedUser;
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
