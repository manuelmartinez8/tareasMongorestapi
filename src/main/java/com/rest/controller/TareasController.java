package com.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Tarea;
import com.rest.service.TareaService;

@RestController
public class TareasController {
	
	 	@Autowired
	    protected TareaService service;
	 	
	 	
		@GetMapping(value="/tareas" , produces = "application/json")
		public ResponseEntity<List<Tarea>> getAllTareas(@RequestParam(required = false)String title){
		try {
			List<Tarea> tareasList = service.getAllItems(title);
			
			if(tareasList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tareasList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
	    
		@PutMapping("/tareas/{id}")
		public ResponseEntity<Tarea> updateTarea(@PathVariable("id") int id, @RequestBody Tarea tarea){
			try {
				Tarea _tarea = service.update(id, tarea);
				if(_tarea != null) {
					return new ResponseEntity<>(_tarea, HttpStatus.OK);	
				}else {
				      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
	    @DeleteMapping("/tarea/{id}")
	    public ResponseEntity  deleteTarea(@PathVariable int id){	    	
	       try {
	    	   service.delete(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	          } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	          }
	    } 	    
	    
	    @PostMapping(value = "/tareas")
	    public ResponseEntity  saveTarea(@RequestBody Tarea tarea){
	        service.create(tarea);
	        return new ResponseEntity(HttpStatus.OK);
	    }  
	    
	    @GetMapping(value="/tarea/{id}" , produces = "application/json")
	    public ResponseEntity getTarea(@PathVariable int id){	
	    	try {	    		
				Tarea _tarea = service.getTarea(id);
				if(_tarea != null) {
					return new ResponseEntity<>(_tarea, HttpStatus.OK);	
				}else {
				      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	    	
	        
	    } 

}
