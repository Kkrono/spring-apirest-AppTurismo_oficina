package com.empresa.AppTurismo.models.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="paises")
public class Paises implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="pais_sequence";
	
	@Id
	private Long id_pais;
	private String nombre_pais;

	public Paises(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	public long getId_pais() {
		return id_pais;
	}

	public void setId_pais(Long id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}