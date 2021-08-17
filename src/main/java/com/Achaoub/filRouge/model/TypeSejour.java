package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the type_sejour database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="type_sejour")
@NamedQuery(name="TypeSejour.findAll", query="SELECT t FROM TypeSejour t")
public class TypeSejour implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_TypeSejour;


	private int libelle;


	public TypeSejour() {
	}


}