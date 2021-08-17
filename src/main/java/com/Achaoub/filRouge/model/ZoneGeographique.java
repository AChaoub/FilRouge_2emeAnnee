package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the zone_geographique database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="zone_geographique")
@NamedQuery(name="ZoneGeographique.findAll", query="SELECT z FROM ZoneGeographique z")
public class ZoneGeographique implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ZoneGeo;

	private String libelle_ZoneGeo;



	public ZoneGeographique() {
	}

	

}