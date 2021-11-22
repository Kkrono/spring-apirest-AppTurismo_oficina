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
@Document(collection="departamentos")
public class Departamentos implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="dep_sequence";
	
	@Id
	private String id_dep;
	private String nombre_dep;
	@DBRef
	private Paises paises;

	private static final long serialVersionUID = 1L;

}