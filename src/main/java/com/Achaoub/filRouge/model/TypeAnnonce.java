package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the type_annonce database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="type_annonce")
@NamedQuery(name="TypeAnnonce.findAll", query="SELECT t FROM TypeAnnonce t")
public class TypeAnnonce implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_TypeAnnonce;


	private int libelle;


	public TypeAnnonce() {
	}

	
}