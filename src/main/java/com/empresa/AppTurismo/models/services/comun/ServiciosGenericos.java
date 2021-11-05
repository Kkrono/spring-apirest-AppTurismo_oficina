package com.empresa.AppTurismo.models.services.comun;

import java.util.List;


public interface ServiciosGenericos<T, ID> {
	List<T> getAll();
	T get(ID id);
	T save(T entity);
	void delete(ID id);
}
