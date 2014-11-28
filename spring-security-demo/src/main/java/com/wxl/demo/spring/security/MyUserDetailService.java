package com.wxl.demo.spring.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
				"ROLE_USER");
		authorities.add(authority);

		if (username.equals("admin")) {
			SimpleGrantedAuthority authority2 = new SimpleGrantedAuthority(
					"ROLE_ADMIN");
			authorities.add(authority2);
		}

		User user = new User(username, "000000", true, true, true, true,
				authorities);
		return user;
	}

}
