package com.project.RestaurentsHere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.RestaurentsHere.model.User;
import com.project.RestaurentsHere.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByUsername(String email)
	{
		User u=userRepository.getUserByUsername(email);
		return u;
	}
	
	public void save(User user)
	{
		 userRepository.save(user);
	}

	public User getByResetPasswordToken(String resetPasswordtoken) {
		return userRepository.findByResetPasswordToken(resetPasswordtoken);
	}

	public void updatePassword(User user, String newpassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(newpassword);
		user.setPassword(encodePassword);

		userRepository.save(user);

	}

	public void updateResetPassword(String token, String email) {
		User user = userRepository.getUserByUsername(email);
		System.out.println("..............");
		System.out.println("updated user email...." + user);

		if (user != null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);
		}

	}

}
