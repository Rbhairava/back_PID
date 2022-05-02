package com.proyecto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.proyecto.dto.LoginUser;
import com.proyecto.dto.NewUser;
import com.proyecto.entity.Role;
import com.proyecto.entity.User;
import com.proyecto.enums.RoleName;
import com.proyecto.jwt.JwtDto;
import com.proyecto.jwt.JwtTokenProvider;
import com.proyecto.service.RoleService;
import com.proyecto.service.UserService;

import lombok.extern.slf4j.Slf4j;

import static com.proyecto.util.UserMessage.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	JwtTokenProvider jwtProvider;
	
	@PostMapping("/register")	
	public ResponseEntity<?> register(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity(WRONG_FIELDS_OR_INVALID_EMAIL, HttpStatus.BAD_REQUEST);
		if(userService.existsByUsername(newUser.getUsername()))
			return new ResponseEntity(USERNAME_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
		if(userService.existsByEmail(newUser.getEmail()))
			return new ResponseEntity(EMAIL_ALREADY_EXISTS, HttpStatus.BAD_REQUEST);
		
		User user = new User(newUser.getName(),newUser.getUsername(),newUser.getEmail(),passwordEncoder.encode(newUser.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
		if (newUser.getRoles().contains("admin"))
			roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
		user.setRoles(roles);
		userService.save(user);
		
		return new ResponseEntity<>(USER_SUCCESSFULLY_CREATED, HttpStatus.CREATED);		
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity(INCORRECT_USERNAME_OR_PASSWORD, HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity<>(jwtDto, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = userService.findAll();
		return ResponseEntity.ok(lista);
	}

}
