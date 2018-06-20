package com.manzuraz.water.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manzuraz.water.models.User;
import com.manzuraz.water.repositories.RoleRepository;
import com.manzuraz.water.repositories.UserRepository;


@Service
public class UserService {
	private final UserRepository ur;
	private final RoleRepository rr;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService (UserRepository ur, RoleRepository rr, BCryptPasswordEncoder bC) {
		this.ur=ur;
		this.rr=rr;
		bCryptPasswordEncoder=bC;
		
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
    
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	public User findById(Long id) {
		return ur.findById(id).get();
	}
    
	public String getType(User u) {
		return u.getType();
	}
	
	public void saveUser(User user) {
		ur.save(user);
	}
}
