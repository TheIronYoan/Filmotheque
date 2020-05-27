package fr.ironcrew.filmotheque.ihm;


import java.util.List;

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

import fr.ironcrew.filmotheque.bll.FilmManager;
import fr.ironcrew.filmotheque.bll.UserManager;

import fr.ironcrew.filmotheque.bo.Artist;
import fr.ironcrew.filmotheque.bo.Category;

import fr.ironcrew.filmotheque.bo.Film;
import fr.ironcrew.filmotheque.bo.User;


@RestController
@SessionAttributes("userLogged")
public class MainController {
  
	@Autowired
	private UserManager um;
	
	@Autowired
	private FilmManager fm;

		/*
	    * Add user in model attribute
	    */
	 //  @ModelAttribute("userLogged")
	 //  public User user() {
	 //     return new User();
	 //  }

	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String welcome() {
			return "Welcome";
		}
	

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String connexion(@RequestParam(name="username") String username
							,@RequestParam(name="password") String password
							,ModelMap model) {
	//	System.out.println(user);
		System.out.println("--------------------------------");
		System.out.println(username + " - " + password);
		try {

			User testedUser = um.authentification(username, password);
			model.addAttribute("userLogged", testedUser);

			return "FilmList";
			}
			catch(Exception e) {
				
				System.out.println("pas d'utilisateur");
			}
			return "FilmList";
		}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String byebye() {
		
		System.out.println("Je viens de me deconnecter");
			return "Welcome";
		}
	
	@RequestMapping(path = "/film/list", method = RequestMethod.GET)
	public String listFilm(@ModelAttribute("userLogged") User user
			) {
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

	/* Yo's Workshop */
	
	@RequestMapping(path = "/TEST", method = RequestMethod.GET)
	public String TEST() {
		Film frime=new Film(2, "Sengoku Gensokyo 4 - The Grand War", 2222, null, null, null);
		
		fm.enregistrerFilm(frime);
			return "Welcome";
		}
	
	/* Yo's Workshop */

}

