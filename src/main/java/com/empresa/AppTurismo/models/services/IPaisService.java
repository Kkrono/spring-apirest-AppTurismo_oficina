package com.empresa.AppTurismo.models.services;


import java.util.List;
import java.util.Optional;


import com.empresa.AppTurismo.models.entity.Paises;

public interface IPaisService {
	public List<Paises> findAll();
	public Optional<Paises> findById(int id);
	public Paises save(Paises pais);
	public void delete(int id);
}
