package com.empresa.AppTurismo.models.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empresa.AppTurismo.models.entity.Paises;

public interface IPaisDao extends MongoRepository<Paises, String>{

}
