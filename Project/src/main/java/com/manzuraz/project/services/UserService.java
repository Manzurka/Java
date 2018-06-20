package com.manzuraz.project.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manzuraz.project.models.User;
import com.manzuraz.project.repositories.RoleRepository;
import com.manzuraz.project.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository ur;
	private final RoleRepository rr;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository ur, RoleRepository rr,BCryptPasswordEncoder bC) {
		this.ur=ur;
		this.rr=rr;
		bCryptPasswordEncoder=bC;
	}
	
	public List<User> all_users(){
		return ur.findAll();
	}
	
	public User findByEmail(String email){
		return ur.findByEmail(email);
	}
	public User findById(Long id) {
		return findById(id);
	}
	
	public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rr.findByName("ROLE_USER"));
        ur.save(user);
    }
     
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(rr.findByName("ROLE_ADMIN"));
        ur.save(user);
    }    
}
