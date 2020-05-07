package com.luv2code.springboot.thymeleafdemo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.dao.UserRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Role;
import com.luv2code.springboot.thymeleafdemo.entity.User;
import com.luv2code.springboot.thymeleafdemo.formobject.RegisterUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public void save(RegisterUser registerUser) {

		User user = new User();

		user.setUserName(registerUser.getUserName().toLowerCase());
		user.setFirstName(registerUser.getFirstName());
		user.setLastName(registerUser.getLastName());
		user.setEmail(registerUser.getEmail().toLowerCase());
		user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
		user.setRoles(Arrays.asList(roleService.findByName("ROLE_EMPLOYEE")));

		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
