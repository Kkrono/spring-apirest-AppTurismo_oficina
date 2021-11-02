package com.empresa.AppTurismo.models.services;


import java.util.List;
import java.util.Optional;

import com.empresa.AppTurismo.models.entity.Departamentos;

public interface IDepService {
	public List<Departamentos> findAll();
	public Optional<Departamentos> findById(int id);
	public Departamentos save(Departamentos dep);
	public void delete(int id);
}
