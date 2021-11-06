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
@Document(collection="regiones")
public class Regiones implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="reg_sequence";
	
	@Id
	Long id_reg;
	@Getter @Setter String nombre_reg;
	@Getter @Setter Long id_dep_fk;

	public Regiones(String nombre_reg,Long id_dep_fk) {
		this.nombre_reg = nombre_reg;
		this.id_dep_fk=id_dep_fk;
	}
	
	private static final long serialVersionUID = 1L;

}