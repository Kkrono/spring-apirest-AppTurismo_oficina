package com.empresa.AppTurismo.models.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="departamentos")
public class Departamentos implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="dep_sequence";
	
	@Id
	Long id_dep;
	@Getter @Setter String nombre_dep;
	@Getter @Setter Long id_pais_fk; 

	public Departamentos(String nombre_dep) {
		this.nombre_dep = nombre_dep;
	}

	private static final long serialVersionUID = 1L;

}