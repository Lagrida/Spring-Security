package com.emsi.run.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	@RequestMapping(value="/")
	public String getIndex(Model model) {
		return "index";
	}
	@Secured("ROLE_SUPERADMIN")
	@RequestMapping(value="/superAdmin")
	public String getSuperAdmin(Model model) {
		return "superadmin";
	}
	@Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String getAdmin(Model model) {
		return "admin";
	}
	@Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value="/user")
	public String getUser(Model model) {
		return "user";
	}
	@RequestMapping("/403")
	public String accessDenied() {
	    return "403";
	}
}
