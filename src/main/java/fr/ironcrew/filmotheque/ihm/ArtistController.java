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
import fr.ironcrew.filmotheque.bll.ArtistNonTrouveException;
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

		
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	@RequestMapping(path = "/artist/add", method = RequestMethod.GET)
	public String addArtistPage() {
		return "ArtistEdit";
	}
	
	@RequestMapping(path = "/artist/add", method = RequestMethod.POST)
	public String addArtist(@RequestParam String action, 
			@RequestParam String firstname,
			@RequestParam String name,
			@RequestParam(defaultValue = "false", required=false) boolean director,
			@RequestParam(defaultValue = "false", required=false) boolean actor,
			@RequestParam String birth,@RequestParam String nation) throws ParseException 
		{
			if ("enregistrer".equals(action)) {
				Artist art= new Artist();
				art.setFirstname(firstname);
				art.setName(name);
				art.setDirector(director);
				art.setActor(actor);
			
				Date birthDate=format.parse(birth);
				art.setBirth(birthDate);
				art.setNationality(nation);
				am.saveArtist(art);
				}
				return "FilmList";
		}
	@RequestMapping(path = "/artist/edit", method = RequestMethod.POST)
	public RedirectView editArtist(@RequestParam String action, 
			@RequestParam(defaultValue = "0",name="id") int id,
			@RequestParam String firstname,
			@RequestParam String name,
			@RequestParam(defaultValue = "false", required=false) boolean director,
			@RequestParam(defaultValue = "false", required=false) boolean actor,
			@RequestParam String birth,@RequestParam String nation) throws ParseException 
		{
			if ("enregistrer".equals(action)) {
				
				Date birthDate=format.parse(birth);
				Artist art= new Artist(id,firstname,name,director,actor,birthDate,nation,null);
				am.saveArtist(art);
				}
			return new RedirectView("/Filmotheque/app/artist/list");
		}
	
	
	
	@RequestMapping(path = "/artist/edit", method = RequestMethod.GET)
	public String editArtist(ModelMap model,
			@RequestParam(defaultValue = "0",name="id") int id 			
			) throws NumberFormatException, ArtistNonTrouveException {
		
			Artist artist = am.findById(id);
			
			if(artist.getBirth()!=null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String strDate= formatter.format(artist.getBirth());
				model.addAttribute("birthDate", strDate);
			}
			model.addAttribute("artist", artist);
		
		return "ArtistEdit";
	}
	
	@RequestMapping(path = "/artist/list", method = RequestMethod.GET)
	public String listArtist(ModelMap model) {
			List<Artist> artists = am.findAllArtist();
			model.addAttribute("artists", artists);
			return "ArtistList";
		}
	@RequestMapping(path = "/artist/delete", method = RequestMethod.GET)
	public String deleteCalidationArtist(
			@RequestParam(defaultValue = "0",name="id") int id,
			ModelMap model) throws ArtistNonTrouveException {
			Artist artist =am.findById(id);
			model.addAttribute("artist", artist);
			return "ArtistDelete";
		}
	@RequestMapping(path = "/artist/delete", method = RequestMethod.POST)
	public RedirectView deleteArtist(
					@RequestParam(defaultValue = "0",name="id") int id,
					ModelMap model) throws ArtistNonTrouveException {
			Artist artist =am.findById(id);
			am.deleteArtist(artist);
			
			return new RedirectView("/Filmotheque/app/artist/list");
		}
	
}

