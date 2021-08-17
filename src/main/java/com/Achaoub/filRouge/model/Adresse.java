package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.*;

/**
 * The persistent class for the adresse database table.
 * 
 */
@Data
@AllArgsConstructor
@ToString
@Entity
@NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Adresse;

	private String adresse;

	private int codeP_Adresse;

	private String ville_Adresse;

	public Adresse() {
	}

}