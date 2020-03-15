package ca.sheridancollege;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import ca.sheridancollege.beans.filtered_dogs;
import ca.sheridancollege.DAO.DAO;
import ca.sheridancollege.beans.dogs;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		
		return "Home.html";
	}
	
	@GetMapping("/adddogs")
	public String dogs(HttpServletRequest request, HttpSession session) {
	dogs d = new dogs();
	String name = request.getParameter("name");
	String ownerName = request.getParameter("ownerName");
	String breed = request.getParameter("breed");
	String group = request.getParameter("group");
	String gender = request.getParameter("gender");
	String ranking = request.getParameter("ranking");
	String email = request.getParameter("email");
	
	
	d.setName(name);
	d.setOwnerName(ownerName);
	d.setBreed(breed);
	d.setGroups(group);
	d.setGender(gender);
	d.setRanking(ranking);
	d.setEmail(email);
	
	DAO.adddogs(d);
	
	return "addDog.html";
	
}
	
	@GetMapping("/addHandler")
	public String addHandler(HttpServletRequest request, HttpSession session) {
   	
		dogs d = new dogs();
	String name = request.getParameter("name");
	String ownerName = request.getParameter("ownerName");
	String breed = request.getParameter("breed");
	String group = request.getParameter("group");
	String gender = request.getParameter("gender");
	String ranking = request.getParameter("ranking");
	String email = request.getParameter("email");
	
	d.setName(name);
	d.setOwnerName(ownerName);
	d.setBreed(breed);
	d.setGroups(group);
	d.setGender(gender);
	d.setRanking(ranking);
	d.setEmail(email);
	
	DAO.addHandler(d);
	return "/user/addHandler.html";
	
}
	
	@GetMapping("/viewdogs")
    public String show(HttpServletRequest request) {
		
		request.setAttribute("doggylist", DAO.getdog());
		return "viewDog.html";
	}
	
	@GetMapping("/viewHandler")
    public String showHandler(HttpServletRequest request) {
		
		request.setAttribute("doggylist", DAO.getHandler());
		return "/user/viewHandler.html";
	}
	
	
	@GetMapping("/searchDogList")
	public String gotoSearchDog() {
		
		return "searchDog.html";
	}
	
	@GetMapping("/searchdogs")
    public String searchdogs(HttpServletRequest request) {
		String search = request.getParameter("search");
		String searchBy = request.getParameter("searchBy");
		
		
		if(searchBy.equalsIgnoreCase("name")) {
			
		request.setAttribute("doggylist",DAO.searchdogbyname(search));	
		}
		
		if(searchBy.equalsIgnoreCase("entry_No")) {
			
		request.setAttribute("doggylist",DAO.searchdogbyno(search));	
		}
		
		if(searchBy.equalsIgnoreCase("ownerName")) {
			
		request.setAttribute("doggylist",DAO.searchdogbyowner(search));	
		}
		
		if(searchBy.equalsIgnoreCase("breed")) {
			
		request.setAttribute("doggylist",DAO.searchdogbybreed(search));	
		}
		
		if(searchBy.equalsIgnoreCase("groups")) {
			
		request.setAttribute("doggylist",DAO.searchdogbygroup(search));	
		}
		return "showSearch.html";
	}
	
	@GetMapping("/user")
	public String goHome(Authentication authentication, Model model) {
		
		String name = authentication.getName();
		ArrayList<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		
		model.addAttribute("username", name);
		model.addAttribute("userRoles", roles);
		
		return "/user/addHandler.html";
	}
	
	@GetMapping("/login")
	public String gologin() {
		return "login.html";
	}
	
	@GetMapping("/access-denied")
	public String error() {
		return "/error/access-denied.html";
	}
	
	@GetMapping("/register")
	public String goreg() {
		return "register.html";
	}
	
	public static String encryptPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	@PostMapping("/register")
	public String doreg(@RequestParam String name,
			@RequestParam String password) {
		DAO.addUser(name, encryptPassword(password));
		long userId = DAO.findUserAccount(name).getUserId();
		DAO.addUserRoles(userId, 1);
		DAO.addUserRoles(userId, 2);
		return "redirect:/";
	}
	
	@GetMapping("/deletelink/{id}")
	public String deletePage(HttpServletRequest request, @PathVariable int id, Model model) {
	DAO.DeleteDogs(id);
	model.addAttribute("doggylist", DAO.getdog());
	return "viewDog.html";

	}
	
	@GetMapping("/editlink/{id}")

	public String editPage(@PathVariable int id, Model model) {

		dogs d = DAO.viewDogsByID(id);
		model.addAttribute("doggylist", d);

	return "modifyDog.html";

	}
	
	
	
	@GetMapping("/modify")

	public String modifyDogs(@RequestParam int id,

	@RequestParam String name,
	@RequestParam String ownerName,
	@RequestParam String breed,
	@RequestParam String group,
	@RequestParam String gender,
	@RequestParam String ranking,
	@RequestParam String email,
	Model model) {
	
		dogs d = new dogs(id,name,ownerName,breed,group,gender,ranking,email);
		DAO.Update(d);
		model.addAttribute("doggylist", DAO.getdog());
		return "viewDog.html";

	}
	
	@GetMapping("/Handler") 
	public String addHandler() {
		return "/user/addHandler.html";
	}
	
}
