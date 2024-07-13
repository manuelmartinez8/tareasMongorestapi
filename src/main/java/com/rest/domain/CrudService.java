package com.rest.domain;

import java.util.Collection;
import java.util.List;

import com.rest.model.Tarea;

public interface CrudService<T> {
	
	public abstract void create(T t );
    public Tarea update(int id, T t);
    public abstract void delete(int id);  
    public abstract List<T> getAllItems(String title);

}
