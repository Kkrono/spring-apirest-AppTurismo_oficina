package com.empresa.AppTurismo.models.services.departamento;


import java.util.List;
import java.util.Optional;

import com.empresa.AppTurismo.models.entity.Departamentos;

public interface IDepService {
	public List<Departamentos> findAll();
	public List<Departamentos> findAllC();
	public Optional<Departamentos> findById(Long id);
	public Departamentos save(Departamentos dep,Long idPais);
	public void delete(Long id);
}
