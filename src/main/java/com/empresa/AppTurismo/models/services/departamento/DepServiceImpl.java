package com.empresa.AppTurismo.models.services.departamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IDepDao;
import com.empresa.AppTurismo.models.entity.Departamentos;
import com.empresa.AppTurismo.models.entity.Paises;
import com.empresa.AppTurismo.models.services.IPaisService;

@Service
public class DepServiceImpl implements IDepService {
	@Autowired
	private IDepDao depDao;
	
	@Autowired
	private IPaisService paisService;
	
	@Override
	public List<Departamentos> findAll() {
		return (List<Departamentos>)depDao.findAll();
	}

	@Override
	public List<Departamentos> findAllC() {
		List<Departamentos> listaDepartamentos= new ArrayList<>();;
		listaDepartamentos=depDao.findAll();
		System.out.println(listaDepartamentos);
		
		return (listaDepartamentos);
	}

	
	@Override
	public Optional<Departamentos> findById(Long id) {
		Optional<Departamentos> dep=depDao.findById(id);		
		//Optional<Paises> pais;
		//paisDao.findById(idPais);
		return dep;
	}

	@Override
	public Departamentos save(Departamentos dep, Long idPais) {
		if (idPais!=0) {
			Optional<Paises> sitioActual = paisService.findById(idPais);
			Paises sitioValues=sitioActual.get();
			System.out.println(sitioValues.getNombre_pais());
			dep.setId_pais_fk(idPais);
		}
		return depDao.save(dep);
	}
	
//	private String buscarNombrePais(Long idPais) {
//		Optional<Paises> sitioActual = paisService.findById(idPais);
//		Paises sitioValues=sitioActual.get();
//		System.out.println(sitioValues.getNombre_pais());
//		return sitioValues.getNombre_pais();
//	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		depDao.deleteById(id);
	}

}