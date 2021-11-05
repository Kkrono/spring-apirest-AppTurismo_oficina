package com.empresa.AppTurismo.models.services.departamento;


import com.empresa.AppTurismo.models.entity.Departamentos;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericos;

public interface IDepService extends ServiciosGenericos<Departamentos, Long> {

	Departamentos verificarPaisExiste(Departamentos dep);

}
