package com.project.RestaurentsHere.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.RestaurentsHere.model.Food;
import com.project.RestaurentsHere.model.User;
import com.project.RestaurentsHere.service.FoodService;
import com.project.RestaurentsHere.service.UserService;
import com.project.RestaurentsHere.util.MailUtils;
import com.project.RestaurentsHere.util.Utility;


//import hr.etermin.system.config.PasswordManager;
import net.bytebuddy.utility.RandomString;

@Controller
public class RestaurentController {
	

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("home page from home..");
		return "home";
		
	}
	
	@RequestMapping("/mylogin")
	public String loginpage()
	{
		
		return "loginpage";
		
	}
	
	@RequestMapping("/index")
	public String index()
	{
		System.out.println("welcome user");
		return "index";
		
	}  
	
	@RequestMapping("/get")
	public String get(Model model,Principal principal, @Param("keyword") String keyword) {
		System.out.println("get api here");
		
		List<Food> restaurents= foodService.listAll(keyword);
		
//		String name=principal.getName();
//		System.out.println(name);
////		User user=userRepository.getUserByUsername(name);
//		List<Food> restaurents = foodRepository.findFoodByUser(name);
		
		
		model.addAttribute("restaurents", restaurents);
		return "showdetails";
	}
	
		
	@RequestMapping("/registeruser")
	public String insertOwnerDetails(Model model)
	{
		model.addAttribute("user", new User());
		System.out.println("inside register page");
		return "registerUser";
	}
	
	@PostMapping("/doregisteruser")
	public String SaveOwnerDetails(@Valid @ModelAttribute("user") User user, Model model) throws IOException
	{
		  int id=  user.getId();
	       
			
			
						if(id == 0)
				{
					System.out.println("save to db....");
					user.setEnabled(true);
					user.setImageUrl("default.png");
					user.setRole("ROLE_"+user.getRole());
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					 userService.save(user);
					model.addAttribute("message", "successfully saved to db");
					
				}
				else
				{
					System.out.println("update to db...");
			
					
						String sql="update user set name=?, password=?, role=?,email=?, about=? where id=?";
						 jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRole(), user.getEmail(), user.getAbout(), user.getId());

						
					
					model.addAttribute("message", "successfully updated to db");
					
				}
			
				return "registerUser";

	} 
	
	
	@RequestMapping("/forgotpassword")
	public String forgotPassword()
	{
		
		System.out.println("inside forgot password page");
		return "forgotpassword";
	}
	
	
	@RequestMapping("/process-forgot-password")
	public String processForgotPassword(HttpServletRequest request, Model model)
	{
		String userid=request.getParameter("email");
		
		String token=RandomString.make(45);
	    try
	    {
	    	System.out.println(userid+"..."+token);
		userService.updateResetPassword(token, userid);
		
		String resetPasswordLink=Utility.getSiteUrl(request)+"/reset_password?token="+token;
		
		System.out.println("\n\n..."+resetPasswordLink);
		String body=  "<h3>Hello, here is your link to reset password </h3><a href= '"+resetPasswordLink+ "'>"+resetPasswordLink+"</a>"
				+ "<h3>If it is not done by you, please ignore </h3>";
				
								
		MailUtils.send("Reset Password Link..", userid, body);    
		model.addAttribute("message", "A reset link has been sent to the email address");
	    }
	    catch (Exception e) {
			// TODO: handle exception
	    	model.addAttribute("message", userid+" address not found");	
	    	
	    }
		return "forgotpassword";
		
	}
	
	@GetMapping("/reset_password")
	public String showResetPassword(@Param(value="token")String token, Model model)
	{
		System.out.println(token);
		User user=userService.getByResetPasswordToken(token);
		if(user==null)
		{
			model.addAttribute("errorMsg", "Invalid token");
			
		}
		model.addAttribute("token", token);
		return "resetpassword";
		
		
	}
	
	@RequestMapping("/process-reset-password")
	public String processResetPassword(HttpServletRequest request, Model model)
	{
		String token=request.getParameter("token");
		String password=request.getParameter("password");
		User user=userService.getByResetPasswordToken(token);
		
		
		
		System.out.println("token is............. "+token);
		
		if(user==null)
		{
			System.out.println("user is null");
			model.addAttribute("errorMsg", "No user found");
		}
		else
		{
			String passField1 = request.getParameter("pwd1");
			String passField2 = request.getParameter("pwd2");
			
	

			 if (passField1.isEmpty()) {
				model.addAttribute("errorMsg", "Password cannot be empty!");
			//	LOG.info("passfield cannot be empty:");
				return "resetpassword";
		
			
		} else if (passField1.equals(passField2)) {
			user.setPassword(passwordEncoder.encode(passField1));
			userService.save(user);
			model.addAttribute("successMsg", "Password changed successfully!");
			//LOG.info("Password changed successfully!");
		}
		else
		{
			model.addAttribute("errorMsg", "password and confirm password do not match");
			return "resetpassword";
			
		}
		}
		
		
		
		return "resetpassword";
		
	}
	
	
	
	@RequestMapping("/showMap")
	public String showMap(Model model)
	{
	//		List<PartnerSaloon> partnerSaloons=partnerSaloonService.findAllByPartnerId(pid);
//		for(PartnerSaloon pss: partnerSaloons)
//		{
//			System.out.println(pss.getLat()+"..........."+pss.getLng());
//		}
//		model.addAttribute("partnerSaloons", partnerSaloons);
		return "gm";
	} 
	

	


}
