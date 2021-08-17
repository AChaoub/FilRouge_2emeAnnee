package com.Achaoub.filRouge.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="corps_image")
	private String corpsImage;

	@Column(name="extension_image")
	private String extensionImage;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idImage;

	public Image() {
	}

	

}