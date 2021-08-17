package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@AllArgsConstructor
@ToString
@Data
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;

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

	public Client() {
	}

}