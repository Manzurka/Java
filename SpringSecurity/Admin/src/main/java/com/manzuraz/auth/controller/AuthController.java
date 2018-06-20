package com.manzuraz.auth.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manzuraz.auth.models.User;
import com.manzuraz.auth.service.UserService;
import com.manzuraz.auth.validator.UserValidator;

@Controller
public class AuthController {
	private UserValidator userValidator;
	private UserService userService;
	    
    public AuthController(UserService userService,UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    	
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
    	if(userService.allUsers().size() == 0) {
    		userService.saveUserWithAdminRole(user);
    	}
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        Date date = new Date();
        model.addAttribute("logintime", date);
        return "index.jsp";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("admin", userService.findRoleByName("ROLE_ADMIN"));
        model.addAttribute("users", userService.allUsers());
        return "adminPage.jsp";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	userService.deleteUserById(id);
        return "redirect:/admin";
    }
    
    @RequestMapping("/make-admin/{id}")
    public String makeAdmin(@PathVariable("id") Long id) {
    	userService.makeAdmin(userService.findUserById(id));
        return "redirect:/admin";
    }
}
