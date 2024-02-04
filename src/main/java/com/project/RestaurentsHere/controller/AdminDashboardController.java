package com.project.RestaurentsHere.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.RestaurentsHere.model.Food;
import com.project.RestaurentsHere.model.User;
import com.project.RestaurentsHere.service.FoodService;
import com.project.RestaurentsHere.service.UserService;

@MultipartConfig
@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

	
	@Autowired
	private FoodService foodService;
	@Autowired
	private UserService userService;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {
		return "dashboard";
	}

	@RequestMapping("/register")
	public String insert(Model model) {
		model.addAttribute("restaurent", new Food());
		System.out.println("inside register page");
		return "reg";
	}

	@PostMapping("/doregister")
	public String SaveContact(@Valid @ModelAttribute("restaurent") Food food, Model model, Principal principal)
			throws IOException {
		// Food food=new Food();
		int id = food.getId();

		// int id2=Integer.parseInt(id);

		String catagory = food.getCatagory();

		// String email= request.getParameter("email");
		String type = food.getType();
		if (food.getId() == 0) {
			String name = principal.getName();
			User user = this.userService.getUserByUsername(name);
//			food.setUser(user);
			System.out.println("save to db....");
			user.getFood().add(food);
			foodService.save(food);

			model.addAttribute("message", "successfully saved to db");
		} else {
			System.out.println("update to db...");

			String sql = "update foodie set name=?, price=?, catagory=?,type=? where id=?";
			jdbcTemplate.update(sql, food.getName(), food.getPrice(), food.getCatagory(),
					food.getType(), food.getId());

			model.addAttribute("message", "successfully updated to db");

		}
		// foodRepo.save(food);
		// model.addAttribute("message", "kya horha");
		return "reg";
	}
	
	
	
//	@PostMapping("/doregister")
//	public String SaveContact(HttpServletRequest request, Principal principal, Model model) throws IOException, ServletException {
//	int id;
//		Food food=new Food();
//		String Id=request.getParameter("id");
//		 
//		if(Id==" " || Id==null)
//		{
//			 Id="0";
//			
//		}
//		 id=Integer.parseInt(Id);
//		System.out.println("id is...."+id);
//		String name=request.getParameter("name");
//		String catagory=request.getParameter("catagory");
//		String type=request.getParameter("type");
//		String price= request.getParameter("price");
//		Double p2=Double.parseDouble(price);
//		model.addAttribute("name", name);
//		model.addAttribute("catagory", catagory);
//		model.addAttribute("type", type);
//		model.addAttribute("price", p2);
//		model.addAttribute("id", id);
//
//		Part file=request.getPart("image");
//		if(file.getSize()==0)
//		{
//			System.out.println("empty file");
//		}
//		System.out.println(name+ type+ p2);
//		System.out.println(file.getSubmittedFileName());
//		if (id == 0) {
//			String uname = principal.getName();
//			User user = this.userRepository.getUserByUsername(uname);
//			food.setName(name);
//			food.setCatagory(catagory);
//			food.setType(type);
//			food.setPrice(p2);
//			food.setUser(user);
//			foodRepository.save(food);
//		
//		model.addAttribute("message", "successfully saved to db");
//		}
//		else
//		{
//			System.out.println("update to db...");
//			
//						String sql = "update foodie set name=?, price=?, catagory=?,type=? where id=?";
//						jdbcTemplate.update(sql, name, price, catagory,
//								type, id); 
//								
//						model.addAttribute("message", "successfully updated to db");
//			
//					
//			
//		}
//		return "reg";
//		
//	
//	}


	@RequestMapping("/edit")
	public String EditContact(@RequestParam("id") int id, Model model) {
		System.out.println("idddddd" + id);
		System.out.println("poiuytrtyhjhgf");
		Food f = foodService.findById(id);
		System.out.println(f.getId() + "" + f.getName() + "");
		model.addAttribute("food", f);
		return "reg";
	}

	@GetMapping("/delete")
	public String DeleteContact(@RequestParam("id") int id) {
		foodService.deleteById(id);
		return "redirect:/get";

	}
	
	@RequestMapping("/change-password")
	public String changePassword(HttpServletRequest request, HttpServletResponse response) {

		//LOG.info("--------Change Passwoord-------");

		HttpSession httpSession = request.getSession();
		//httpSession.setAttribute("APP_NAME", APPLICATION_NAME);
//		if (httpSession.getAttribute("USER") == null)
//			return "redirect:/mylogin";

		return "changepassword";
	}

	@RequestMapping("/update-password")
	public String updatePassword(HttpServletRequest request, HttpServletResponse response, Principal principal, Model model) {

		HttpSession httpSession = request.getSession();
//		if (httpSession.getAttribute("USER") == null)
//			return "redirect:/mylogin";
        
		String name=principal.getName();
		User user =userService.getUserByUsername(name);
		//User user = userService.findByUserId(userId);
		String passField1 = request.getParameter("passField1");
		System.out.println(passField1+"....");
		String passField2 = request.getParameter("passField2");

	//	LOG.info("passfield 1 length : " + passField1.length());

		if (passField1.isEmpty()) {
			model.addAttribute("errorMsg", "Password cannot be empty!");
	//		LOG.info("passfield cannot be empty:");
			return "changepassword";
		} else if (!passField1.equals(passField2)) {
			model.addAttribute("errorMsg", "Passwords do not match!");
			//LOG.info("Passwords do not match!");
			return "changepassword";
		} else if (passField1.equals(passField2)) {
			user.setPassword(passwordEncoder.encode(passField1));
			userService.save(user);
			model.addAttribute("successMsg", "Password changed successfully!");
			//LOG.info("Password changed successfully!");
			System.out.println("password successfully changed");
		}

		return "redirect:/index";
	}
	

}
