package com.emsi.run;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.emsi.run.entities.Role;
import com.emsi.run.entities.User;
import com.emsi.run.repository.RoleRepository;
import com.emsi.run.repository.UserRepository;
import com.emsi.run.security.MD5Encoder;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringsecurityApplication.class, args);
		
		/*
		 * Le block suivant sert à ajouter 3 roles et 3 users
		 * Après le premier lancement, commenter depuis "Debut" jusqu'aux "Fin"
		*/
		/*
		// Debut
		Role rl1, rl2, rl3;
		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		
		// Création des roles
		rl1 = new Role("SUPERADMIN");
		rl2 = new Role("ADMIN");
		rl3 = new Role("USER");
		
		// Enregistrer les roles dans la base de donnèe
		roleRepository.save(rl1);
		roleRepository.save(rl2);
		roleRepository.save(rl3);
		
		HashSet<Role> roles = new HashSet<Role>();
		try {
			// Création de user lagrida avec le role superadmin 
			String password, encodedPassword;
			password = "123456";
			encodedPassword = MD5Encoder.encode(password);
			User superAdmin = new User("lagrida", encodedPassword);
			roles.add(rl1);
			superAdmin.setRoles(roles);
			userRepository.save(superAdmin);
			// Création de user user1 avec le role admin
			User admin = new User("user1", encodedPassword);
			roles.clear();
			roles.add(rl2);
			admin.setRoles(roles);
			userRepository.save(admin);
			// Création de user user2 avec le role user
			User user = new User("user2", encodedPassword);
			roles.clear();
			roles.add(rl3);
			user.setRoles(roles);
			userRepository.save(user);
		}catch(NoSuchAlgorithmException ex) {
			
		}
		// Fin
		*/
	}
}
