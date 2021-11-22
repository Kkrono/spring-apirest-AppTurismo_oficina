package com.empresa.AppTurismo.models.services.regiones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IRegionDao;
import com.empresa.AppTurismo.models.entity.Departamentos;
import com.empresa.AppTurismo.models.entity.Regiones;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericosImpl;
import com.empresa.AppTurismo.models.services.departamento.IDepService;

@Service
public class RegionServiceImpl extends ServiciosGenericosImpl<Regiones, String> implements IRegionService {

	@Autowired
	private IRegionDao regionDao;
	@Autowired
	private IDepService depService;

	@Override
	public CrudRepository<Regiones, String> getDao() {
		// TODO Auto-generated method stub
		return regionDao;
	}

	@Override
	public Regiones verificarDepExiste(Regiones regiones) {
		// TODO Auto-generated method stub
		if (regiones.getDep()!=null) {
			Departamentos sitioActual = depService.get(regiones.getDep().getId_dep());
			Departamentos sitioValues=sitioActual;
			System.out.println(sitioValues.getNombre_dep());
		}
		return regiones;
	}

}
