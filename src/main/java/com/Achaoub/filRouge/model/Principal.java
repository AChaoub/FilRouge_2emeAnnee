package com.Achaoub.filRouge.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import static java.util.Arrays.stream;

public class Principal implements UserDetails {

	private static final long serialVersionUID = 8575398322368976138L;
	private Client client;

	public Principal(Client client) {
		this.client = client;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		GrantedAuthority authority = new SimpleGrantedAuthority("role" + user.getRole());
//		authorities.add(authority);
//		return authorities;
		return null;
		//return stream(this.user.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.client.getEncryptedPassword();
	}

	@Override
	public String getUsername() {
		return this.client.getNomClient();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}