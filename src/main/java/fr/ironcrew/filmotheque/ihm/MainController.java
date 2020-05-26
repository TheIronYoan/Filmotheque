package fr.ironcrew.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fr.ironcrew.filmotheque.bll.FilmManager;
import fr.ironcrew.filmotheque.bll.UserManager;


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
	
	
}

