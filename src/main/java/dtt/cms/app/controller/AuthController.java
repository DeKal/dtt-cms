package dtt.cms.app.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dtt.cms.app.common.ResourceMapping;

import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class AuthController {
	
	@GetMapping(ResourceMapping.LOGIN_PAGE_URL)
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return ResourceMapping.LOGIN_PAGE_RESOURCE;
		}
		else {
			return "redirect:" + ResourceMapping.HOME_PAGE_URL;
		}
	}
}
