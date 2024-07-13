package com.rest.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Tarea")
public class Tarea implements Serializable {

	    @Id
	    @NonNull	    
	    private int id;
	    private LocalDate  fvencimiento;
	    private String title;
	    private String description;
	    private String estado;
	    
		
	    
	    
 
}
