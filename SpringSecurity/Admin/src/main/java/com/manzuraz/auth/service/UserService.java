package com.manzuraz.auth.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manzuraz.auth.models.Role;
import com.manzuraz.auth.models.User;
import com.manzuraz.auth.repositories.RoleRepository;
import com.manzuraz.auth.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public List<User> allUsers() {
    	return userRepository.findAll();
    }
    public Role findRoleByName(String role){
    	return roleRepository.findByName(role).get(0);
    }
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    public void makeAdmin(User user) {
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
	    userRepository.save(user);
    }
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }
    
    public void deleteUserById(Long id) {
    	userRepository.deleteById(id);
    }
    
}
