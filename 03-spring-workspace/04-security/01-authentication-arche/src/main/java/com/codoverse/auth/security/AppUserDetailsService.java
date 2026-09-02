package com.codoverse.auth.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codoverse.auth.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		var appUser = userRepository.findByUsername(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
		
		return User.builder()
					.username(appUser.getUsername())
					.password(appUser.getPassword())
					.roles(appUser.getRole().replace("ROLE_", ""))
					.build();
	}

}
