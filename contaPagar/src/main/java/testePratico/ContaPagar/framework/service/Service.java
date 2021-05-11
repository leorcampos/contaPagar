package testePratico.ContaPagar.framework.service;

import java.io.Serializable;
import java.util.List;

import testePratico.ContaPagar.framework.persistencia.Dao;

public interface Service <E, ID extends Serializable> {

	public List<E> findAll();
	
	public E findById(ID id);
	
	public E save(E entity);
	
	public E merge(E entity);
	
	public void delete(ID id);
	
	public Dao<E, ID> getDao();
}