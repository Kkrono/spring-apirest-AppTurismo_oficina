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
@Document(collection="comidasTipicas")
public class ComidasTipicas implements Serializable {
	@Transient
	public static final String SEQUENCE_NAME="comidasTipicas_sequence";
	
	@Id
	Long id_pla;
	@Getter @Setter String nombre_pla;
	@Getter @Setter String imagen_pla;
	@Getter @Setter String descipcion_pla;
	@Getter @Setter Long id_sit_fk;

	public ComidasTipicas(String nombre_pla, String imagen_pla, String descipcion_pla, Long id_sit_fk) {
		this.nombre_pla = nombre_pla;
		this.imagen_pla = imagen_pla;
		this.descipcion_pla = descipcion_pla;
		this.id_sit_fk = id_sit_fk;
	}
	private static final long serialVersionUID = 1L;
}