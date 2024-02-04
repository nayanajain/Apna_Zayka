package com.project.RestaurentsHere.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.RestaurentsHere.model.User;
import com.project.RestaurentsHere.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetching user from database
		User user=userRepository.getUserByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("could not found user");
		}
		CustomUserDetail customuserdetails=new CustomUserDetail(user);
		
		return customuserdetails;
	}

	
}
