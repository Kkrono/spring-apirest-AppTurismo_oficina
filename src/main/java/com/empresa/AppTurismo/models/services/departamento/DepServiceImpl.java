package com.empresa.AppTurismo.models.services.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IDepDao;
import com.empresa.AppTurismo.models.entity.Departamentos;
import com.empresa.AppTurismo.models.entity.Paises;
import com.empresa.AppTurismo.models.services.comun.ServiciosGenericosImpl;
import com.empresa.AppTurismo.models.services.pais.IPaisService;

@Service
public class DepServiceImpl extends ServiciosGenericosImpl<Departamentos, Long> implements IDepService {
	@Autowired
	private IDepDao depDao;
	@Autowired
	private IPaisService paisService;

	@Override
	public CrudRepository<Departamentos, Long> getDao() {
		// TODO Auto-generated method stub
		return depDao;
	}

	@Override
	public Departamentos verificarPaisExiste(Departamentos dep) {
		// TODO Auto-generated method stub
		if (dep.getId_pais_fk()!=0) {
			Paises sitioActual = paisService.get(dep.getId_pais_fk());
			Paises sitioValues=sitioActual;
			System.out.println(sitioValues.getNombre_pais());
		}
		return dep;
	}


}