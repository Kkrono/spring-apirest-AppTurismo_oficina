package com.empresa.AppTurismo.models.services.regiones;

import com.empresa.AppTurismo.models.entity.Regiones;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericos;

public interface IRegionService extends ServiciosGenericos<Regiones, String>{
	Regiones verificarDepExiste(Regiones regiones);
}
