package com.empresa.AppTurismo.models.services.comidastipicas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IComidasTipicasDao;
import com.empresa.AppTurismo.models.entity.ComidasTipicas;
import com.empresa.AppTurismo.models.entity.Sitios;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericosImpl;
import com.empresa.AppTurismo.models.services.sitios.ISitioService;

@Service
public class ComidasTipicasServiceImpl extends ServiciosGenericosImpl<ComidasTipicas, Long> implements IComidasTipicasService {

	@Autowired
	private IComidasTipicasDao comidasTipicasDao;
	@Autowired
	private ISitioService sitioService;
	
	@Override
	public CrudRepository<ComidasTipicas, Long> getDao() {
		// TODO Auto-generated method stub
		return comidasTipicasDao;
	}	

	@Override
	public ComidasTipicas verificarSitiosExiste(ComidasTipicas comidasTipicas) {
		// TODO Auto-generated method stub
		if (comidasTipicas.getId_sit_fk()!=0) {
			Sitios sitioActual = sitioService.get(comidasTipicas.getId_sit_fk());
			Sitios sitioValues=sitioActual;
			System.out.println(sitioValues.getNombre_sit());
		}
		return comidasTipicas;
	}

	
	
}
