package com.empresa.AppTurismo.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.AppTurismo.models.dao.IPaisDao;
import com.empresa.AppTurismo.models.entity.Paises;

@Service
public class PaisServiceImpl implements IPaisService {
	@Autowired
	private IPaisDao paisDao;

	@Override
	public List<Paises> findAll() {
		// TODO Auto-generated method stub
		return (List<Paises>)paisDao.findAll();
	}

	@Override
	public Optional<Paises> findById(int id) {
		// TODO Auto-generated method stub
		return paisDao.findById(id);
	}

	@Override
	public Paises save(Paises pais) {
		// TODO Auto-generated method stub
		return paisDao.save(pais);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		paisDao.deleteById(id);
	}

}