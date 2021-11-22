package com.empresa.AppTurismo.models.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empresa.AppTurismo.models.entity.Departamentos;

public interface IDepDao extends MongoRepository<Departamentos, String> {


}
