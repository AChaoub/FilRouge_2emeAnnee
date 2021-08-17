package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Rating_;



	private String note_Rating;



	public Rating() {
	}

	

}