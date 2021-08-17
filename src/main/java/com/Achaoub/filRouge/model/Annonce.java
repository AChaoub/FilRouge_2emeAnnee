package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * The persistent class for the annonce database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")
public class Annonce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date_Annonce;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Annonce;

	private int id_Immobilier;

	private int id_Personne;

	public Annonce() {
	}

}