package fr.ironcrew.filmotheque.bo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="categories")
@Component(value="category")
public class Category {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Film> films;
	
	public Category() {
		
	}

	public Category(int id, String name, List<Film> films) {

		super();
		this.id = id;
		this.name = name;
		this.films = films;
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


	public List<Film> getFilms() {
		return films;
	}


	public void setFilms(List<Film> films) {
		this.films = films;
	}

	
	
}
