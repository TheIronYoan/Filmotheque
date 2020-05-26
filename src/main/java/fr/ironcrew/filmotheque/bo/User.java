package fr.ironcrew.filmotheque.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component(value="user")
public class User {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String name;
	private String username;
	private String email;

	private String password;

	private Boolean poweruser;
	private Boolean administrator;
	
	
	
	public User() {
		
	}
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Boolean getPoweruser() {
		return poweruser;
	}



	public void setPoweruser(Boolean poweruser) {
		this.poweruser = poweruser;
	}



	public Boolean getAdministrator() {
		return administrator;
	}



	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}


	

	

}
