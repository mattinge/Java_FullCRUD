package com.inge.club.book.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.inge.club.book.models.LoginUser;
import com.inge.club.book.models.User;
import com.inge.club.book.repositories.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User validateRegister(User newUser, BindingResult result) {
		if(!newUser.getConfirmPassword().equals(newUser.getPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Passwords must match.");
		}
		Optional<User> optUser = userRepo.findByEmail(newUser.getEmail());
		if(optUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email already in use.");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			return userRepo.save(newUser);
		}
	 
	}
	
	public User validateLogin(LoginUser newLogin, BindingResult result) {
		Optional<User> optUser = userRepo.findByEmail(newLogin.getLoginEmail());
		if(!optUser.isPresent()) {
			result.rejectValue("loginEmail", "Matches", "Email/Password is incorrect");
			result.rejectValue("loginPassword", "Matches", "Email/Password is incorrect");
			return null;
		}
		User validUser = optUser.get();
		if(!BCrypt.checkpw(newLogin.getLoginPassword(), validUser.getPassword())) {
			result.rejectValue("loginEmail", "Matches", "Email/Password is incorrect");
			result.rejectValue("loginPassword", "Matches", "Email/Password is incorrect");
			return null;
		}
		return validUser;
	}
	
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		return optUser.orElseGet(() -> null);
	}
	
	public User findByEmail(String email) {
		Optional<User> optUser = userRepo.findByEmail(email);
		return optUser.orElseGet(() -> null);
	}
	
	public User updateUser(User aUser) {
		return userRepo.save(aUser);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}