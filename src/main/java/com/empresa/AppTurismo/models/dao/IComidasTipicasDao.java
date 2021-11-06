package com.empresa.AppTurismo.models.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empresa.AppTurismo.models.entity.ComidasTipicas;

public interface IComidasTipicasDao extends MongoRepository<ComidasTipicas, Long> {

}
