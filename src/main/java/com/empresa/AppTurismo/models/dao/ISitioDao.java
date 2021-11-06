package com.empresa.AppTurismo.models.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empresa.AppTurismo.models.entity.Sitios;

public interface ISitioDao extends MongoRepository<Sitios, Long> {

}
