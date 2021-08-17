package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the details_colocataire database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="details_colocataire")
@NamedQuery(name="DetailsColocataire.findAll", query="SELECT d FROM DetailsColocataire d")
public class DetailsColocataire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="animaux_domestique")
	private boolean animauxDomestique;

	private boolean fumeur;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Details;

	private int intervalleAge_Coloc_Min;
	
	private int intervalleAge_Coloc_Max;

	private int nbr_Coloc;

	private String sexe_Coloc;

	public DetailsColocataire() {
	}

	
}