package com.Achaoub.filRouge.model.request;

import lombok.Data;

public @Data class ClientRequest {

	private int id;
	private String userId;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String role;

	public ClientRequest() {

	}

	public ClientRequest(String nom, String prenom ,String email,String userId,String password,String role) {
		this.nom = nom;
		this.prenom=prenom;
		this.email = email;
		this.userId = userId;
		this.password= password;
		this.role = role;
	}
}
