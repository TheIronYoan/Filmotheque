package fr.ironcrew.filmotheque.ihm;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
import fr.ironcrew.filmotheque.bll.CategoryManager;
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
	
	@Autowired
	private ArtistManager am;

	@Autowired
	private CategoryManager cm;

	
	
	@RequestMapping(path = "/init", method = RequestMethod.GET)
	public String initalize() {
		Film film1=new Film(2, "Sengoku Gensokyo 4 - The Grand War", 2222, null, null, null);
		fm.enregistrerFilm(film1);
		Film film2=new Film(2, "Retour vers le futur ", 1985 , null, null, null);
		fm.enregistrerFilm(film2);
		Film film3=new Film(2, "Harry Potter a l'ecole des sorciers ", 2001, null, null, null);
		fm.enregistrerFilm(film3);
		Film film4=new Film(2, "Star Trek ", 2009, null, null, null);
		fm.enregistrerFilm(film4);
			
			return "Welcome";
		}
	


}

