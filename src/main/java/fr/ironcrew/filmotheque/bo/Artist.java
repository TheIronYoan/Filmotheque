package fr.ironcrew.filmotheque.bo;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="artists")
@Component(value="artist")
public class Artist {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="firstname")
	private String firstname;


	@Column(name="name")
	private String name;


	@Column(name="director")
	private boolean director;


	@Column(name="actor")
	private boolean actor;


	@Column(name="birth")
	private LocalDate birth;


	@Column(name="nationality")
	private String nationality;

	@ManyToMany(mappedBy = "actors")
	private List<Film> filmsActor;

	public Artist() {
		super();
	}


	

	public Artist(int id, String firstname, String name, boolean director, boolean actor, LocalDate birth,
			String nationality, List<Film> filmsActor) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.name = name;
		this.director = director;
		this.actor = actor;
		this.birth = birth;
		this.nationality = nationality;
		this.filmsActor = filmsActor;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public boolean isDirector() {
		return director;
	}


	public void setDirector(boolean director) {
		this.director = director;
	}


	public boolean isActor() {
		return actor;
	}


	public void setActor(boolean actor) {
		this.actor = actor;
	}


	public LocalDate getBirth() {
		return birth;
	}


	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}




	public List<Film> getFilmsActor() {
		return filmsActor;
	}




	public void setFilmsActor(List<Film> filmsActor) {
		this.filmsActor = filmsActor;
	}
	
	
	
}
