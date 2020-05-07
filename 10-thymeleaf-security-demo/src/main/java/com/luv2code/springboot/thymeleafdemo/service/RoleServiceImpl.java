package com.luv2code.springboot.thymeleafdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.RoleRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

}
