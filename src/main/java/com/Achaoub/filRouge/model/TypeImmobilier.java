package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the type_immobilier database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="type_immobilier")
@NamedQuery(name="TypeImmobilier.findAll", query="SELECT t FROM TypeImmobilier t")
public class TypeImmobilier implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_TypeImmbilier;

	private String libelle_TypeImmbilier;

	public TypeImmobilier() {
	}



}