package com.empresa.AppTurismo.models.services.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IPaisDao;
import com.empresa.AppTurismo.models.entity.Paises;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericosImpl;


@Service
public class PaisServiceImpl extends ServiciosGenericosImpl<Paises, String> implements IPaisService {
		
	@Autowired
	private IPaisDao paisDao;

	@Override
	public CrudRepository<Paises, String> getDao() {
		// TODO Auto-generated method stub
		return paisDao;
	}

	
}