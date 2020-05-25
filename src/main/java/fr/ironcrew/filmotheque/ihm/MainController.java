package fr.ironcrew.filmotheque.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.ironcrew.filmotheque.bll.ConnexionRefuseeException;
import fr.ironcrew.filmotheque.bo.User;



@Controller
@SessionAttributes("monAttibut")

public class MainController {


	
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

