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
@Document(collection="comidasTipicas")
public class ComidasTipicas implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="comidasTipicas_sequence";
	
	@Id
	private String id_pla;
	private String nombre_pla;
	private String imagen_pla;
	private String descipcion_pla;
	@DBRef
	private Sitios sitio;

	private static final long serialVersionUID = 1L;

}