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

	private static final long serialVersionUID = 1L;

	public Paises(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}


}