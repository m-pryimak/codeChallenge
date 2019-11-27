package com.adidas.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service  
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		final List<AppUser> users = Arrays.asList(
			new AppUser("user", encoder.encode("user"), "USER"),
			new AppUser("admin", encoder.encode("admin"), "ADMIN")
		);
		

		for(AppUser appUser: users) {
			if(appUser.getUsername().equals(username)) {				
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		                	.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
				
				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
			}
		}
		
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
	
	private static class AppUser {
	    private String username;
	    private String password;
	    private String role;
	    
		public AppUser(String username, String password, String role) {
	    	this.username = username;
	    	this.password = password;
	    	this.role = role;
	    }

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

	    public String getRole() {
			return role;
		}
	}
}
