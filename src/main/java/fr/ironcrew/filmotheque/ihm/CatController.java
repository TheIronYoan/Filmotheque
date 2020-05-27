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
public class CatController {
  

	@Autowired
	private CategoryManager cm;

	@RequestMapping(path = "/category/list", method = RequestMethod.GET)
	public String listCategory(ModelMap model)  {
		List<Category> categories = cm.findAllCategory();
		model.addAttribute("categories", categories);
		return "CategoryList";
	}
	

	@RequestMapping(path = "/category/add", method = RequestMethod.GET)
	public String addCategoryPage() {
		return "CategoryCreate";
	}
	
	@RequestMapping(path = "/category/add", method = RequestMethod.POST)
	public String addCategory(@RequestParam String action, @RequestParam String cat)  {
		if ("enregistrer".equals(action)) {
			Category categorie= new Category();
			categorie.setName(cat);
			cm.enregistrerCategory(categorie);
		}
			return "FilmList";
		}
	@RequestMapping(path = "/category/delete", method = RequestMethod.GET)
	public String deleteCategory() {
		return "CategoryCreate";
	}
	
}

