package com.manzuraz.project.controllers;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manzuraz.project.models.User;
import com.manzuraz.project.services.UserService;
import com.manzuraz.project.validator.UserValidator;

@Controller
public class UsersController {
	private final UserService us;
	private final UserValidator userValidator;
	
	public UsersController(UserService us,UserValidator uv){
		this.us=us;
		this.userValidator=uv;
	}

	@RequestMapping("/login") 
		public String home(@ModelAttribute("user") User user,@RequestParam(value="error", required=false) String error, 
				@RequestParam(value="logout", required=false) String logout, Model model){
		if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
    
		return "loginPage.jsp";
	}
	
	
	@RequestMapping("/registration") 
		public String reg(@Valid @ModelAttribute("user") User user, BindingResult result, 
				Model model, HttpSession session, HttpServletRequest request) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
            return "loginPage.jsp";
        }
        us.saveWithUserRole(user);
        try {
            request.login(user.getEmail(),user.getPasswordConfirmation());
        } catch (ServletException e) {
            System.out.println("IT DID NOT WORK :C");
        }
        return "redirect:/ideas";
	}
	
	
}
