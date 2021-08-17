package com.Achaoub.filRouge.shared.dto;

import java.io.Serializable;

import lombok.Data;

public @Data class ClientDto implements Serializable {

	private static final long serialVersionUID = -8593162992891859581L;

	private int id;

	private String nomClient;
	
	private String emailClient;

	private String passwordClient;

	private String encryptedPassword;

	private String prenomClient;

	private String roleClient;

	private String statusClient;

	private String telephoneClient;

	private String userIDClient;

	private boolean acpActualitesClient;

	private boolean cguClient;

	private int idType;

	private int noteApprcClient;

	private String imageProfClient;

	private boolean isValidClient;

}
