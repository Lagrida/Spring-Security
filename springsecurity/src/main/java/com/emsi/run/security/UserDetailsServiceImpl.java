package com.emsi.run.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emsi.run.repository.UserRepository;
import com.emsi.run.entities.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	public UserDetailsServiceImpl() {
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElse(null);
		if(user == null){
			throw new UsernameNotFoundException("Pas de user : "+username);
		}else{
			return new UserDetailsImpl(user);
		}
	}

}
