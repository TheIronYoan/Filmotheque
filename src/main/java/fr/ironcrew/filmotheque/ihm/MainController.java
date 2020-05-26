package fr.ironcrew.filmotheque.ihm;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ironcrew.filmotheque.bll.FilmManager;
import fr.ironcrew.filmotheque.bll.UserManager;
import fr.ironcrew.filmotheque.bo.Artist;
import fr.ironcrew.filmotheque.bo.Category;
import fr.ironcrew.filmotheque.bo.Film;


@RestController
public class MainController {
    // Autowired desativé le temps de finir les DAO , BO , DAL
	@Autowired
	private UserManager um;
	
	@Autowired
	private FilmManager fm;
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String welcome() {
			return "Welcome";
		}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String Connexion(@RequestParam(name="pseudo") String idUser
							,@RequestParam(name="mdp") String mdp
							,ModelMap model) {
		
			return "FilmList";
		}
	
	
	/* Yo's Workshop */
	
	@RequestMapping(path = "/TEST", method = RequestMethod.GET)
	public String TEST() {
		Film frime=new Film(2, "Sengoku Gensokyo 4 - The Grand War", 2222, null, null, null);
		
		fm.enregistrerFilm(frime);
			return "Welcome";
		}
	
	/* Yo's Workshop */
}

