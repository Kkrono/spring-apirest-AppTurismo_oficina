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
@Document(collection="sitios")
public class Sitios implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="sitios_sequence";
	
	@Id
	Long id_sit;
	@Getter @Setter String nombre_sit;
	@Getter @Setter String descripcion_sit;
	@Getter @Setter String imagen_sit;
	@Getter @Setter Long id_reg_fk;

	public Sitios(String nombre_sit, String descripcion_sit, String imagen_sit, Long id_reg_fk) {
		this.nombre_sit = nombre_sit;
		this.descripcion_sit = descripcion_sit;
		this.imagen_sit = imagen_sit;
		this.id_reg_fk = id_reg_fk;
	}

	private static final long serialVersionUID = 1L;

}