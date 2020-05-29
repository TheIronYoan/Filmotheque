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
import fr.ironcrew.filmotheque.bll.FilmNonTrouveException;
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
	
	//charge la création de films
	@RequestMapping(path = "/film/add", method = RequestMethod.GET)
	public String addFilmPage(ModelMap model) throws FilmNonTrouveException,ArtistNonTrouveException {

		model=addFilmLoader(model);

		model.addAttribute("numAct", 1);
		
		return "FilmCreate";
	}
	
	//crée un nouveau film
	@RequestMapping(path = "/film/add", method = RequestMethod.POST)
	public String addFilm(@RequestParam String action, @RequestParam(required=false) String name,@RequestParam(required=false) int release,
			@RequestParam int cat,@RequestParam int director,
			@RequestParam(value="actors[]") int[] actors,	//permet d'obtenir une liste d'acteurs via le formulaire (j'ai pas les détails de comment ca marche malheureusement, mais il semblerait qu'avec une certaine syntaxe html on peut imiter une liste)
			@RequestParam int numAct,ModelMap model) throws ParseException, CategoryNonTrouveException, ArtistNonTrouveException {
		
		//enregistre le nouveau film
		if ("enregistrer".equals(action)) {
			if(name.length()<1||release<=0) {
				model=addFilmLoader(model);
				model.addAttribute("numAct", numAct);
				return "FilmCreate";
			}
			Film film= new Film();
			film.setName(name);
			film.setReleaseDate(release);
			Category category=cm.findById(cat);
			film.setCategory(category);
			Artist usedDirector=am.findById(director);
			film.setDirector(usedDirector);
			List<Artist> usedActors= film.getActors();
			
			//décompose la liste des acteurs obtenu en parametres
			for(int actor : actors) {
				usedActors.add(am.findById(actor));
			}
			System.out.println("number="+usedActors.size());
			
			fm.enregistrerFilm(film);
		}
		
		
		//ajoute un nouveau champ acteur
		if ("plus".equals(action)) {
			model=addFilmLoader(model);
			model.addAttribute("numAct", numAct+1);
			return "FilmCreate";
		}
		//retire un champ acteur
		if ("minus".equals(action)) {
			model=addFilmLoader(model);
			if(numAct>1) {
				model.addAttribute("numAct", numAct-1);
			}else {
				model.addAttribute("numAct", numAct);
			}
			return "FilmCreate";
		}
			List<Film> films = fm.findAllFilms();
			model.addAttribute("films", films);
			return "FilmList";
		}
	
	//charge la liste des films
	@RequestMapping(path = "/film/list", method = RequestMethod.GET)
	public String listFilm(
			ModelMap model) {
			List<Film> films = fm.findAllFilms();
			model.addAttribute("films", films);
			return "FilmList";
		}
	
	//charge la liste des films
	@RequestMapping(path = "/film/list", method = RequestMethod.POST)
	public RedirectView listFilmViaPost(ModelMap model) {
			List<Film> films = fm.findAllFilms();
			model.addAttribute("films", films);
			return new RedirectView("/Filmotheque/app/film/list");
		}
	

	//affiche le film souhaité (non finalisé)
	@RequestMapping(path = "/film/show", method = RequestMethod.GET)
	public String showFilm(	@RequestParam(defaultValue = "0",name="film") String idFilm ,
			ModelMap model) throws NumberFormatException, FilmNonTrouveException {
		if(Integer.parseInt(idFilm) != 0) {
			 
			Film showedFilm= fm.findById(Integer.parseInt(idFilm));
			model.addAttribute("film",showedFilm);
		 
		}
		
			return "FilmShow";		
		}
	
	
	//charge la modification de films
	@RequestMapping(path = "/film/edit", method = RequestMethod.GET)
	public String editFilm(	@RequestParam(defaultValue = "0",name="id") String idFilm ,
			ModelMap model) throws NumberFormatException, FilmNonTrouveException {
		System.out.println (idFilm);
			if(Integer.parseInt(idFilm) != 0) {
				model=addFilmLoader(model);
				model.addAttribute("numAct", 1);
				Film film= fm.findById(Integer.parseInt(idFilm));
				model.addAttribute("film",film);
				
				return "FilmEdit";
			}
			
			return "FilmList";
		}
	
	
	//Modifie le film, fonctonne similairement a ajout film
	@RequestMapping(path = "/film/edit", method = RequestMethod.POST)
	public String editFilmEdit(@RequestParam String action,
			@RequestParam(required=false) String id,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) int release,@RequestParam int cat,@RequestParam int director,
			@RequestParam(value="actors[]") int[] actors, @RequestParam int numAct,ModelMap model)
					throws ParseException, CategoryNonTrouveException, ArtistNonTrouveException, NumberFormatException, FilmNonTrouveException {
	
		if ("enregistrer".equals(action)) {
			if(name.length()<1||release<=0) {
				model=addFilmLoader(model);
				model.addAttribute("numAct", 1);
				Film film= fm.findById(Integer.parseInt(id));
				model.addAttribute("film",film);
				
				return "FilmEdit";
			}
			Film film= fm.findById(Integer.parseInt(id));
			film.setName(name);
			film.setReleaseDate(release);
			Category category=cm.findById(cat);
			film.setCategory(category);
			Artist usedDirector=am.findById(director);
			film.setDirector(usedDirector);
			
			//Modifier les acteurs est un peu trop complexe pour le temps fourni avec notre systeme
			/*List<Artist> usedActors= film.getActors();
			for(int actor : actors) {
				usedActors.add(am.findById(actor));
			}
			System.out.println("number="+usedActors.size());*/
			
			fm.modifierFilm(film);
		}
		
		
		
		if ("plus".equals(action)) {
			model=addFilmLoader(model);
			model.addAttribute("numAct", numAct+1);
			return "FilmCreate";
		}
		if ("minus".equals(action)) {
			model=addFilmLoader(model);
			model.addAttribute("numAct", numAct-1);
			return "FilmCreate";
		}
			List<Film> films = fm.findAllFilms();
			model.addAttribute("films", films);
			return "FilmList";
		}
		
	
	@RequestMapping(path = "/film/delete", method = RequestMethod.GET)
	public RedirectView deleteFilm(	@RequestParam(defaultValue = "0",name="id") String idFilm ,
			ModelMap model) throws NumberFormatException, FilmNonTrouveException {
			
			if(Integer.parseInt(idFilm) != 0) {
				Film film=fm.findById(Integer.parseInt(idFilm));
				fm.supprimerFilm(film);
				// Film editedFilm= tm.findById(Integer.parseInt(idFilm));
				// model.addAttribute("film",editedFilm);
			}
			return new RedirectView("/Filmotheque/app/film/list");
		}
	
	
	//Ammene a la recherche de film
	@RequestMapping(path = "/film/search", method = RequestMethod.GET)
	public String searchFilm(ModelMap model){
			model=addFilmLoader( model);
			return "FilmSearch";
		}
	
	
	//lance la requete avec filtres des films
	@RequestMapping(path = "/film/search", method = RequestMethod.POST)
	public String searchFilmSend(
			@RequestParam(required=false) String name,
			@RequestParam(required=false) int releaseAfter,@RequestParam(required=false) int releaseBefore,
			@RequestParam int cat,@RequestParam int director,
			@RequestParam int actor,ModelMap model)
					throws ParseException, CategoryNonTrouveException, ArtistNonTrouveException, NumberFormatException, FilmNonTrouveException {
			List<Film> films=fm.rechercheFilm(name, cat, releaseAfter, releaseBefore, director, actor);
			model.addAttribute("films", films);
			return "FilmList";
		}
	
	//charge les listes pour les options categorie/realisateur/acteur
	public ModelMap addFilmLoader(ModelMap model) {
		List<Category> cats=cm.findAllCategory();
		List<Artist> acts=am.findAllActors();
		List<Artist> dirs=am.findAllDirectors();
		model.addAttribute("actors", acts);
		model.addAttribute("directors", dirs);
		model.addAttribute("cats", cats);
		return model;
	}
	
	
	
	
}

