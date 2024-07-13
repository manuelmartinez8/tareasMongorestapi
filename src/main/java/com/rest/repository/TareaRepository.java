package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.Tarea;

public interface TareaRepository  extends MongoRepository<Tarea, Integer>{

}
