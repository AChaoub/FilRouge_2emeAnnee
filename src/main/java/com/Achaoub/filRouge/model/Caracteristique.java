package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * The persistent class for the caracteristiques database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name = "caracteristiques")
@NamedQuery(name = "Caracteristique.findAll", query = "SELECT c FROM Caracteristique c")
public class Caracteristique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Carcteristiques;
	
	private boolean accessibilite;

	private boolean ascensseur;

	private boolean balcon;

	private String bus;

	private boolean couvertureInternet;

	private boolean cuisinePartage;

	private boolean installation_Adsl;

	private boolean machineLave;

	private boolean meuble;

	private boolean parking;

	public Caracteristique() {
	}

}