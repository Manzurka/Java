package com.manzuraz.event.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manzuraz.event.models.User;
import com.manzuraz.event.repositories.RoleRepository;
import com.manzuraz.event.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository ur;
	private final RoleRepository rr;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository ur, RoleRepository rr, BCryptPasswordEncoder bc) {
		this.ur=ur;
		this.rr=rr;
		this.bCryptPasswordEncoder = bc;
	}
	
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	public User findById(Long id) {
		return ur.findById(id).get();
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
    public List<User> allUsers(){
    	return ur.findAll();
    }
}
