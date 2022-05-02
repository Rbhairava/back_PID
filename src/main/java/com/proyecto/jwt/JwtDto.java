package com.proyecto.jwt;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import com.proyecto.entity.User;

import lombok.Getter;
import lombok.Setter;

public class JwtDto {

	private String token;
	private String bearer = "Bearer";
//	private int id;
//	private String name; 
	private String username;
//	private String email;
//	private Date lastLoginDate;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDto(String token, String username, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.username = username;
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
		
}
