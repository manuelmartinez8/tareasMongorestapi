package com.rest.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.domain.CrudService;
import com.rest.model.Tarea;
import com.rest.repository.TareaRepository;
import com.rest.repository.TareasRepositorio;

@Service
public class TareaService implements CrudService<Tarea>{
	
    @Autowired
    TareaRepository repository;
    
    @Autowired
    protected TareasRepositorio repositorio;

	@Override
	public void create(Tarea t) {
	repository.save(t);		
	}

	@Override
	public Tarea update(int id, Tarea t) {		
		Tarea tareaData = repository.findById(id).orElse(null);
		if(tareaData!=null) {
			Tarea _tarea = new Tarea();
			_tarea.setId(t.getId());
			_tarea.setTitle(t.getTitle());
			_tarea.setDescription(t.getDescription());
			_tarea.setEstado(t.getEstado());
			repository.save(t);
			return _tarea;
		}
		 return null;		
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);		
	}
	
	public Tarea getTarea(int id) {
		return repository.findById(id).orElse(null);
	}	

	@Override
	public List<Tarea> getAllItems(String title) {
		List<Tarea> tareasList = new ArrayList<Tarea>();
		 try {
				if(title==null)
					repositorio.findAll().forEach(tareasList::add);
				else
					repositorio.findByTitleContaining(title).forEach(tareasList::add);
				
				
			 tareasList= repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tareasList;
	}



}
