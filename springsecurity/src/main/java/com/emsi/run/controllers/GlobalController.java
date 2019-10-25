package com.emsi.run.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emsi.run.entities.User;
import com.emsi.run.repository.UserRepository;

// Creer une vatiable globale pour récuperer l'objet du user connecté.

@ControllerAdvice
public class GlobalController {
	@Autowired
	private UserRepository userRepository;
	
	@ModelAttribute("userConnected")
	public User getUserConnected(RedirectAttributes redirectAttributes) {
		User userConnected;
		String username = "";
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = "";
		}
		userConnected = userRepository.findByUsername(username).orElse(new User(0, "visiteur"));
		redirectAttributes.addFlashAttribute("userConnected", userConnected);
		return userConnected;
	}
}