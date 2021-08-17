package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * The persistent class for the immobilier database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@NamedQuery(name="Immobilier.findAll", query="SELECT i FROM Immobilier i")
public class Immobilier implements Serializable {
	private static final long serialVersionUID = 1L;




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Immobilier;

	private int nbr_Chambres;



	@Column(name="prix_compelentaire")
	private Long prixCompelentaire;



	@Column(name="prix_location")
	private Long prixLocation;



	private int superficie_Immobilier;


	public Immobilier() {
	}



}