package com.java.ro.invoices.controler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.ro.invoices.model.to.UserAuthenticationTO;
import com.java.ro.invoices.model.to.UserTO;
import com.java.ro.invoices.model.to.UserWithTokenTO;
import com.java.ro.invoices.security.TokenUtils;

@Controller
public class SecurityController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userService;
	
	@RequestMapping(value="/user", method= RequestMethod.GET)
	public @ResponseBody UserTO getUser() {
		Authentication authectication =	SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authectication.getPrincipal();
		return new UserTO(userDetails.getUsername(), createRoleMap(userDetails));
	}
	
	@RequestMapping(value="/authenticate", method= RequestMethod.POST)
	public @ResponseBody UserWithTokenTO authenticate(@RequestBody UserAuthenticationTO userAuthentication) {
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userAuthentication.getUsername(), userAuthentication.getPassword());
		authenticationManager.authenticate(authToken);
		
		// we need to load again user because user passwor after authentication is null
		
		UserDetails userDetails = (UserDetails) userService.loadUserByUsername(userAuthentication.getUsername());
		return new UserWithTokenTO(new UserTO(userDetails.getUsername(), createRoleMap(userDetails)), 
				TokenUtils.createToken(userDetails));
	}
	
	private Map<String, Boolean> createRoleMap(UserDetails userDetails) {
		Map<String, Boolean> roles = new HashMap<String, Boolean>();
		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			roles.put(authority.getAuthority(), Boolean.TRUE);
		}
		return roles;
	}
	
}
