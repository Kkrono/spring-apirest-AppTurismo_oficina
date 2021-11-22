package com.empresa.AppTurismo.models.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="sitios")
public class Sitios implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="sitios_sequence";
	
	@Id
	private String id_sit;
	private String nombre_sit;
	private String descripcion_sit;
	private String imagen_sit;
	@DBRef
	private Regiones region;

	private static final long serialVersionUID = 1L;
}