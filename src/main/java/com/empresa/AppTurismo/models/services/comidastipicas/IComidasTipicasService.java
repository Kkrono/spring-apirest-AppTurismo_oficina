package com.empresa.AppTurismo.models.services.comidastipicas;

import com.empresa.AppTurismo.models.entity.ComidasTipicas;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericos;

public interface IComidasTipicasService extends ServiciosGenericos<ComidasTipicas, String> {
	ComidasTipicas verificarSitiosExiste(ComidasTipicas comidasTipicas);
}
