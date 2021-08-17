package com.Achaoub.filRouge.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.User;
import com.Achaoub.filRouge.SpringApplicationContext;
import com.Achaoub.filRouge.model.request.ClientLoginRequest;
import com.Achaoub.filRouge.services.ClientService;
import com.Achaoub.filRouge.shared.dto.ClientDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



public class AuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authentificationManager;

	public AuthentificationFilter(AuthenticationManager authentificationManager) {
		this.authentificationManager = authentificationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			ClientLoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), ClientLoginRequest.class);
			return authentificationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub

		String userName = ((User) authResult.getPrincipal()).getUsername();

		// UserPrincipal principal =(UserPrincipal) authResult.getPrincipal();

		ClientService clientService = (ClientService) SpringApplicationContext.getBean("userServiceImpl");

		ClientDto clientDto = clientService.getClient(userName);

		String token = Jwts.builder().setSubject(userName).claim("id", clientDto.getId())
				.claim("name", clientDto.getNomClient() + " " + clientDto.getPrenomClient()).claim("role", clientDto.getRoleClient())
				.claim("auth", clientDto.getRoleClient())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET).compact();

		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		//response.addHeader("client_id", clientDto.getId());
		response.addHeader("client_Email", clientDto.getEmailClient());
		response.addHeader("client_id",clientDto.getId()+"");

		response.getWriter().write("{\"token\": \"" + token + "\", \"id\": \"" + clientDto.getId() + "\"}");
	}

}
