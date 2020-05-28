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
import fr.ironcrew.filmotheque.bll.CategoryNonTrouveException;
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
	public RedirectView addCategory(@RequestParam String cat)  {
							
			Category categorie= new Category();
			categorie.setName(cat);
			cm.saveCategory(categorie);
			return new RedirectView("/Filmotheque/app/category/list");
		}
	

	@RequestMapping(path = "/category/edit", method = RequestMethod.GET)
	public String editCategoryPage(
				@RequestParam(defaultValue = "0",name="id") int id,
				ModelMap model) throws CategoryNonTrouveException {
		Category category =cm.findById(id);
		model.addAttribute("category", category);
		return "CategoryEdit";
	}
	
	@RequestMapping(path = "/category/edit", method = RequestMethod.POST)
	public RedirectView editCategory(
									@RequestParam(defaultValue = "0",name="id") int id,
									@RequestParam String cat) throws CategoryNonTrouveException  {
			
			Category category = cm.findById(id);
			category.setName(cat);
			cm.saveCategory(category);
			return new RedirectView("/Filmotheque/app/category/list");
	}
	
	
	@RequestMapping(path = "/category/delete", method = RequestMethod.GET)
	public String deleteValidationCategory(
					@RequestParam(defaultValue = "0",name="id") int id,
					ModelMap model) throws CategoryNonTrouveException {
		Category category =cm.findById(id);
		model.addAttribute("category", category);
		return "CategoryDelete";
	}
	
	
	@RequestMapping(path = "/category/delete", method = RequestMethod.POST)
	public RedirectView deleteCategory(
			@RequestParam(defaultValue = "0",name="id") int id,
			ModelMap model) throws CategoryNonTrouveException  {
			System.out.println("recherche de la category d'ID =>  "+id);
			Category category =cm.findById(id);
			System.out.println(category.getName());
			cm.deleteCategory(category);
			
		return new RedirectView("/Filmotheque/app/category/list");
		
	}
	
}

