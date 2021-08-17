package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * The persistent class for the historiques database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="historiques")
@NamedQuery(name="Historique.findAll", query="SELECT h FROM Historique h")
public class Historique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date_Historique;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Historique;




	public Historique() {
	}

	
}