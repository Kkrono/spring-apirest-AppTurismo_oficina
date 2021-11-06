package com.empresa.AppTurismo.models.services.sitios;

import com.empresa.AppTurismo.models.entity.Sitios;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericos;

public interface ISitioService extends ServiciosGenericos<Sitios, Long> {
	Sitios verificarRegionExiste(Sitios sitios);
}
