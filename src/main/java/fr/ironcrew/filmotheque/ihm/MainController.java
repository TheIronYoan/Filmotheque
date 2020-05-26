package fr.ironcrew.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fr.ironcrew.filmotheque.bll.FilmManager;
import fr.ironcrew.filmotheque.bll.UserManager;
import fr.ironcrew.filmotheque.bo.Film;


@Controller
public class MainController {
    // Autowired desativé le temps de finir les DAO , BO , DAL
	 @Autowired
	 private UserManager um;
	 private FilmManager fm;
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String welcome() {
			return "Welcome";
		}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String Connexion(@RequestParam(name="pseudo") String idUser
							,@RequestParam(name="mdp") String mdp
							,ModelMap model) {
		
			return "FilmsList";
		}
	
	@RequestMapping(path = "/film/list", method = RequestMethod.GET)
	public String listFilm() {
			return "FilmList";
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
			return "FilmEdit";
		}
}

