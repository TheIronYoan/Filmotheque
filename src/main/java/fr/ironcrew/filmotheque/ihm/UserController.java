package fr.ironcrew.filmotheque.ihm;


import org.springframework.beans.factory.annotation.Autowired;
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
import fr.ironcrew.filmotheque.bll.CategoryManager;
import fr.ironcrew.filmotheque.bo.User;


@RestController
@SessionAttributes("userLogged")
public class UserController {
  
	@Autowired
	private UserManager um;
	
	@Autowired
	private FilmManager fm;
	
	@Autowired
	private ArtistManager am;

	@Autowired
	private CategoryManager cm;

		
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String welcome() {
			return "Welcome";
		}
	

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public RedirectView connexion(@RequestParam(name="username") String username
							,@RequestParam(name="password") String password
							,ModelMap model) {
		
			try {

				User testedUser = um.authentification(username, password);
				
				if(!testedUser.getUsername().equals("inconnu")) {
					model.addAttribute("userLogged", testedUser);
				}
				else {
					return new RedirectView("login");
				}
	
				return new RedirectView("film/list");
			}
			catch(Exception e) {
				
				System.out.println("pas d'utilisateur");
			}
			return new RedirectView("film/list");
		}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String byebye() {
		
		System.out.println("Je viens de me deconnecter");
			return "Welcome";
		}
	
}

