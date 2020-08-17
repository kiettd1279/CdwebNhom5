package com.laptrinhweb.config;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	private final String JWT_SECRET = "tanluc";

	private final Long JWT_EXPIRATION = 604800000L;

	public String generateToken(UserDetails details) {
		Date date = new Date();
		Date expiration = new Date(date.getTime() + JWT_EXPIRATION);
		return Jwts.builder().setSubject(details.getUsername()).setIssuedAt(date).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();

	}

	public String getUserNameByToken(String token) {
		Claims claim = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		// out choox nafy dde biet them
		return claim.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException ex) {
			System.err.println("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			System.err.println("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			System.err.println("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			System.err.println("JWT claims string is empty.");
		} finally {
		}
		return false;
	}

}
