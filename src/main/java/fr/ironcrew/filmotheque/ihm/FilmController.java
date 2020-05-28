package fr.ironcrew.filmotheque.ihm;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.ironcrew.filmotheque.bll.FilmManager;
import fr.ironcrew.filmotheque.bll.UserManager;
import fr.ironcrew.filmotheque.bll.ArtistManager;
import fr.ironcrew.filmotheque.bll.ArtistNonTrouveException;
import fr.ironcrew.filmotheque.bll.CategoryManager;
import fr.ironcrew.filmotheque.bll.CategoryNonTrouveException;
import fr.ironcrew.filmotheque.bo.Artist;
import fr.ironcrew.filmotheque.bo.Category;

import fr.ironcrew.filmotheque.bo.Film;
import fr.ironcrew.filmotheque.bo.User;


@RestController
@SessionAttributes("userLogged")
public class FilmController {
  

	@Autowired
	private FilmManager fm;
	
	@Autowired
	private CategoryManager cm;

	@Autowired
	private ArtistManager am;
	
	@RequestMapping(path = "/film/add", method = RequestMethod.GET)
	public String addFilmPage(ModelMap model) {
		List<Category> cats=cm.findAllCategory();
		List<Artist> acts=am.findAllActors();
		System.out.println(cats.size());
		List<Artist> dirs=am.findAllDirectors();
		model.addAttribute("actors", acts);
		model.addAttribute("directors", dirs);
		model.addAttribute("cats", cats);
		model.addAttribute("numAct", 1);
		return "FilmCreate";
	}
	
	@RequestMapping(path = "/film/add", method = RequestMethod.POST)
	public String addFilm(@RequestParam String action, @RequestParam String name,@RequestParam int release,
			@RequestParam int cat,@RequestParam int director,
			@RequestParam(value="actors[]") int[] actors,
			@RequestParam int numAct,ModelMap model) throws ParseException, CategoryNonTrouveException, ArtistNonTrouveException {
	
		if ("enregistrer".equals(action)) {
			Film film= new Film();
			film.setName(name);
			film.setReleaseDate(release);
			Category category=cm.findById(cat);
			film.setCategory(category);
			Artist usedDirector=am.findById(director);
			film.setDirector(usedDirector);
			ArrayList<Artist> usedActors= new ArrayList<Artist>();
			for(int actor : actors) {
				usedActors.add(am.findById(actor));
			}
			System.out.println("number="+usedActors.size());
			
			film.setActors(usedActors);
			fm.enregistrerFilm(film);
		}
		
		
		if ("plus".equals(action)) {
			List<Category> cats=cm.findAllCategory();
			List<Artist> acts=am.findAllActors();
			System.out.println(cats.size());
			List<Artist> dirs=am.findAllDirectors();
			model.addAttribute("actors", acts);
			model.addAttribute("directors", dirs);
			model.addAttribute("cats", cats);
			model.addAttribute("numAct", numAct+1);
		}
			return "FilmList";
		}
	
	
	@RequestMapping(path = "/film/list", method = RequestMethod.GET)
	public String listFilm(
			ModelMap model) {
			List<Film> films = fm.findAllFilms();
			model.addAttribute("films", films);
			return "FilmList";
		}
	
	@RequestMapping(path = "/film/list", method = RequestMethod.POST)
	public RedirectView listFilmViaPost(ModelMap model) {
			List<Film> films = fm.findAllFilms();
			model.addAttribute("films", films);
			return new RedirectView("/Filmotheque/app/film/list");
		}
	

	@RequestMapping(path = "/film/show", method = RequestMethod.GET)
	public String showFilm(	@RequestParam(defaultValue = "0",name="film") String idFilm ,
			ModelMap model) {
		if(Integer.parseInt(idFilm) != 0) {
			 
			// Film showedFilm= fm.findById(Integer.parseInt(idFilm));
			// model.addAttribute("film",showedFilm);
		 
		}
		
			return "FilmShow";		
		}
	
	
	
	@RequestMapping(path = "/film/edit", method = RequestMethod.GET)
	public String editFilm(	@RequestParam(defaultValue = "0",name="film") String idFilm ,
			ModelMap model) throws NumberFormatException {
			
			if(Integer.parseInt(idFilm) != 0) {
				// Film editedFilm= tm.findById(Integer.parseInt(idFilm));
				// model.addAttribute("film",editedFilm);
			}
			return "FilmCreate";
		}
	
	@RequestMapping(path = "/film/delete", method = RequestMethod.GET)
	public RedirectView deleteFilm(	@RequestParam(defaultValue = "0",name="id") String idFilm ,
			ModelMap model) throws NumberFormatException {
			
			if(Integer.parseInt(idFilm) != 0) {
				System.out.println(">>======>>>   Je supprime le film "+ idFilm);
				// Film editedFilm= tm.findById(Integer.parseInt(idFilm));
				// model.addAttribute("film",editedFilm);
			}
			return new RedirectView("/Filmotheque/app/film/list");
		}
	

}

