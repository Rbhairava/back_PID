package com.proyecto.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.proyecto.entity.UserPrincipal;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {
	
	private final static Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication authentication) {		
		UserPrincipal userPrimary = (UserPrincipal) authentication.getPrincipal();
		List<String> roles = userPrimary.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		Map<String, Object> params = new HashMap<>();
		params.put("id", userPrimary.getId());
		params.put("name", userPrimary.getName());
		params.put("email", userPrimary.getEmail());
		params.put("roles", roles);
		return Jwts.builder()
				.setSubject(userPrimary.getUsername())
				.addClaims(params)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			log.error("Token mal formado");
		} catch (UnsupportedJwtException e) {
			log.error("Token no soportado");
		} catch (ExpiredJwtException e) {
			log.error("Token expirado");
		} catch (IllegalArgumentException e) {
			log.error("Token vac??o");
		} catch (SignatureException e) {
			log.error("Fall?? en la firma");
		}
		return false;
	}
	
}
