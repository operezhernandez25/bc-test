package com.diomedes.bcsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diomedes.bcsecurity.model.Usuario;
import com.diomedes.bcsecurity.repository.UsuariosRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsuariosRepository userRepository;


	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
				Usuario user = userRepository.findById(username).get();

		return UserDetailsImpl.build(user);
	}

}