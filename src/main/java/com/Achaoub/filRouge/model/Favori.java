package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="favoris")
@NamedQuery(name="Favori.findAll", query="SELECT f FROM Favori f")
public class Favori implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Favoris;


	public Favori() {
	}

	

}