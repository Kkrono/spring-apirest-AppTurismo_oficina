package com.empresa.AppTurismo.models.services.sitios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.ISitioDao;
import com.empresa.AppTurismo.models.entity.Regiones;
import com.empresa.AppTurismo.models.entity.Sitios;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericosImpl;
import com.empresa.AppTurismo.models.services.regiones.IRegionService;

@Service
public class SitioServiceImplementacion extends ServiciosGenericosImpl<Sitios, Long> implements ISitioService {

	@Autowired
	private ISitioDao sitioDao;
	@Autowired
	private IRegionService regionService;
	
	@Override
	public CrudRepository<Sitios, Long> getDao() {
		// TODO Auto-generated method stub
		return sitioDao;
	}
	
	@Override
	public Sitios verificarRegionExiste(Sitios sitios) {
		// TODO Auto-generated method stub
		if (sitios.getId_reg_fk()!=0) {
			Regiones sitioActual = regionService.get(sitios.getId_reg_fk());
			Regiones sitioValues=sitioActual;
			System.out.println(sitioValues.getNombre_reg());
		}
		return sitios;
	}


}
