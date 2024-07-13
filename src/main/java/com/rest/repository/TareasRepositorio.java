package com.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.Tarea;

 

public interface TareasRepositorio extends MongoRepository<Tarea,  String>{

	  List<Tarea> findByTitleContaining(String title);
	  List<Tarea> findByEstado(boolean estado);

}
