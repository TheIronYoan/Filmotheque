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
public class ArtistController {
  
	@Autowired
	private UserManager um;
	
	@Autowired
	private FilmManager fm;
	
	@Autowired
	private ArtistManager am;

	@Autowired
	private CategoryManager cm;

		
	
	
	@RequestMapping(path = "/artist/add", method = RequestMethod.GET)
	public String addArtistPage() {
		return "ArtistCreate";
	}
	
	@RequestMapping(path = "/artist/add", method = RequestMethod.POST)
	public String addArtist(@RequestParam String action, @RequestParam String firstname,@RequestParam String name,
			@RequestParam(defaultValue = "false", required=false) boolean director,@RequestParam(defaultValue = "false", required=false) boolean actor,
			@RequestParam String birth,@RequestParam String nation) throws ParseException {
		if ("enregistrer".equals(action)) {
			Artist art= new Artist();
			art.setFirstname(firstname);
			art.setName(name);
			art.setDirector(director);
			art.setActor(actor);

			System.out.println(birth);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date birthDate=format.parse(birth);
			art.setBirth(birthDate);
			art.setNationality(nation);
			am.enregistrerArtist(art);
		}
			return "FilmList";
		}
	
	@RequestMapping(path = "/artist/edit", method = RequestMethod.GET)
	public String editArtist(
			@RequestParam(defaultValue = "0",name="artist") String idArtist 
			) {
		if(Integer.parseInt(idArtist) != 0) {
			// Film editedFilm= tm.findById(Integer.parseInt(idFilm));
			// model.addAttribute("film",editedFilm);
		}
		return "ArtistEdit";
	}
	
	@RequestMapping(path = "/artist/list", method = RequestMethod.GET)
	public String listArtist(ModelMap model) {
			List<Artist> artists = am.findAllArtist();
			model.addAttribute("artists", artists);
			return "ArtistList";
		}
	
}

