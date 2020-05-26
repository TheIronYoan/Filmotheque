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
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="poweruser")
	private Boolean poweruser;
	
	@Column(name="administrator")
	private Boolean administrator;
	
	
	
	public User() {
		
	}
	
	
	
	public User(Long id, String firstname, String name, String username, String email, String password,
			Boolean poweruser, Boolean administrator) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.poweruser = poweruser;
		this.administrator = administrator;
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
