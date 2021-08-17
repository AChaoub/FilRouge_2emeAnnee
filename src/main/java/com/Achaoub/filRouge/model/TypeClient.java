package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the type_client database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="type_client")
@NamedQuery(name="TypeClient.findAll", query="SELECT t FROM TypeClient t")
public class TypeClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Type;

	private String libelle_Type;


	public TypeClient() {
	}

	
}