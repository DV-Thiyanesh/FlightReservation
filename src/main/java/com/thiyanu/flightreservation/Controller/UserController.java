package com.thiyanu.flightreservation.Controller;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiyanu.flightreservation.entities.User;
import com.thiyanu.flightreservation.repository.UserRepository;


@Controller
public class UserController {
	
	
    @Autowired
	private UserRepository userrepository;
	
 private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/registerpage")
	public String registerpage() {
		LOGGER.info("Inside registerpage()");
		return "login/registerpage";
	}
	
	@RequestMapping("/loginpage")
	public String loginpage() {
		LOGGER.info("Inside loginpage()");
		return "login/loginpage";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register():"+user);
		 userrepository.save(user);
		
		return "login/loginpage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap map) {
		LOGGER.info("Inside login() and the Email is:"+email);
		 User userlogin = userrepository.findByEmail(email);
		 
		 if(userlogin.getPassword().equals(password)) {
			 
			 return "login/searchflight";
		 }
		 else {
			 String msg="Invalid username or password";
			 map.addAttribute("msg", msg);
		 }
		
		return "login/loginpage";
	}
	
}
