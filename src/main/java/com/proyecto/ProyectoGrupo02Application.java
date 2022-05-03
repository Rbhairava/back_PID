package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.proyecto.entity.Role;
import com.proyecto.enums.RoleName;
import com.proyecto.service.RoleService;
import com.proyecto.service.UserService;

@SpringBootApplication
public class ProyectoGrupo02Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoGrupo02Application.class, args);
	}
	
//	Psdt: Ejecutar 1 sola ves
//	@Autowired
//	RoleService roleService;
//	
//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
//			Role roleUser = new Role(RoleName.ROLE_USER);
//			roleService.save(roleAdmin);
//			roleService.save(roleUser);
//		};
//	}

}
