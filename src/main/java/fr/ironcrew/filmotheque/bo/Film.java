package fr.ironcrew.filmotheque.bo;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private LocalDate releaseDate;
	
//	@Column(name="category")
//	private Category category;
//	
//	@Column(name="director")
//	private Artist director;
//	
//	@Column(name="actors")
//	private List<Artist> actors;

	public Film() {
		super();
	}

	public Film(int id, String name, LocalDate releaseDate, Category category, Artist director, List<Artist> actors) {
		super();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
//		this.category = category;
//		this.director = director;
//		this.actors = actors;
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

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public Artist getDirector() {
//		return director;
//	}
//
//	public void setDirector(Artist director) {
//		this.director = director;
//	}
//
//	public List<Artist> getActors() {
//		return actors;
//	}
//
//	public void setActors(List<Artist> actors) {
//		this.actors = actors;
//	}

	
}
