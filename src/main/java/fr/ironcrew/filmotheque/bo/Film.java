package fr.ironcrew.filmotheque.bo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="films")
@Component(value="film")
public class Film {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="releaseDate")
	private int releaseDate;

	@ManyToOne
    @JoinColumn(name="category_id", nullable=true) 
	private Category category;
	
	@ManyToOne
    @JoinColumn(name="director_id", nullable=true)
	private Artist director;
	
	
	@ManyToMany(cascade= CascadeType.MERGE)
    @JoinTable(
        name = "film_actor", 
        joinColumns = { @JoinColumn(name = "film_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
	private List<Artist> actors;


	public Film() {
		super();
		this.actors= new ArrayList<Artist>();
	}

	public Film(int id, String name, int releaseDate, Category category, Artist director, List<Artist> actors) {
		this();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.category = category;
		this.director = director;
		this.actors = actors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Artist getDirector() {
		return director;
	}

	public void setDirector(Artist director) {
		this.director = director;
	}


	public List<Artist> getActors() {
		return actors;
	}

	/*public void setActors(List<Artist> actors) {
		this.actors = actors;
	}*/

	
}
