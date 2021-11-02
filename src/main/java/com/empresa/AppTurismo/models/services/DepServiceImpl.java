package com.empresa.AppTurismo.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IDepDao;
import com.empresa.AppTurismo.models.dao.IPaisDao;
import com.empresa.AppTurismo.models.entity.Departamentos;
import com.empresa.AppTurismo.models.entity.Paises;

@Service
public class DepServiceImpl implements IDepService {
	@Autowired
	private IDepDao depDao;
	private IPaisDao paisDao;
	
	
	@Override
	public List<Departamentos> findAll() {
		// TODO Auto-generated method stub
		return (List<Departamentos>)depDao.findAll();
	}

	@Override
	public Optional<Departamentos> findById(int id) {
		Optional<Departamentos> dep=depDao.findById(id);		
		//Optional<Paises> pais;
		//paisDao.findById(idPais);
		return dep;
	}

	@Override
	public Departamentos save(Departamentos dep) {
		// TODO Auto-generated method stub
		return depDao.save(dep);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		depDao.deleteById(id);
	}

}