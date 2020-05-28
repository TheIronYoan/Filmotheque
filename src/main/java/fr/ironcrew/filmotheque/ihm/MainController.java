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
		/*User user1= new User(1, "Bruno ", "HUDBERT", "bhudbert", "bruno.hudbert2019@campus-eni.fr", "e10adc3949ba59abbe56e057f20f883e",true, true);
		um.saveUser(user1);
		User user2= new User(2, "poweruser ", "ENI", "poweruser", "poweruser@campus-eni.fr", "e10adc3949ba59abbe56e057f20f883e", true,false);
		um.saveUser(user2);
		User user3= new User(3, "user ", "ENI", "user", "user@campus-eni.fr", "e10adc3949ba59abbe56e057f20f883e",false, false);
		um.saveUser(user3);
		User user4= new User(4, "Yoan ", "COTTREL", "ycottrel", "yoan.cottrel2019@campus-eni.fr", "e10adc3949ba59abbe56e057f20f883e",true, true);
		um.saveUser(user4);
		*/
		Category cat1=new Category(1,"Comedie",null);
		cm.enregistrerCategory(cat1);
		Category cat2=new Category(2,"Fantastique",null);
		cm.enregistrerCategory(cat2);
		Category cat3=new Category(3,"Drame",null);
		cm.enregistrerCategory(cat3);
		
		
		Artist artist1= new Artist(1,"Daniel","RADCLIFE",false,true,null,"Anglais",null);
		am.enregistrerArtist(artist1);
		Artist artist2= new Artist(2,"Chris","PINE",false,true,null,"Americain",null);
		am.enregistrerArtist(artist2);
		Artist artist3= new Artist(3,"Jeffrey Jacob","ABRAMS",true,false,null,"Americain",null);
		am.enregistrerArtist(artist3);
		Artist artist4= new Artist(4,"Kenneth","BRANAGH",true,true,null,"Americain",null);
		am.enregistrerArtist(artist4);
		Artist artist5= new Artist(5,"Michael J.","FOX",false,true,null,"Americain",null);
		am.enregistrerArtist(artist5);
		Artist artist6= new Artist(6,"Robert","ZEMECKIS",true,false,null,"Americain",null);
		am.enregistrerArtist(artist6);
		Artist artist7= new Artist(7,"Chris","COLLOMBUS",true,false,null,"Americain",null);
		am.enregistrerArtist(artist7);
		Artist artist8= new Artist(8,"Emma","WATSON",false,true,null,"Anglais",null);
		am.enregistrerArtist(artist8);
		Artist artist9= new Artist(9,"Ruppert","GRINT",false,true,null,"Anglais",null);
		am.enregistrerArtist(artist9);
		Artist artist10= new Artist(10,"Zachary","QUINTO",false,true,null,"Americain",null);
		am.enregistrerArtist(artist10);
		
		
		Film film1=new Film(1, "Sengoku Gensokyo 4 - The Grand War", 2022, null, null, null);
		fm.enregistrerFilm(film1);
		Film film2=new Film(2, "Retour vers le futur ", 1985 , null, null, null);
		fm.enregistrerFilm(film2);
		Film film3=new Film(3, "Harry Potter a l'ecole des sorciers ", 2001, null, null, null);
		fm.enregistrerFilm(film3);
		Film film4=new Film(4, "Star Trek ", 2009, null, null, null);
		fm.enregistrerFilm(film4);
			
			return "Welcome";
		}
	


}

