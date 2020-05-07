package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Role;

public interface RoleService {
	
	Role findByName(String name);

}
