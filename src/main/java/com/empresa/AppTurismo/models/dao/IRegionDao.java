package com.empresa.AppTurismo.models.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empresa.AppTurismo.models.entity.Regiones;

public interface IRegionDao extends MongoRepository<Regiones, Long> {

}
