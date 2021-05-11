package testePratico.ContaPagar.framework.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import testePratico.ContaPagar.framework.exception.ObjectNotFoundException;

public abstract class ServiceImpl <E, ID extends Serializable> implements Service<E, ID>{

	private Class<E> serviceImpClass;
	
	@SuppressWarnings("unchecked")
	public ServiceImpl() {
		this.serviceImpClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	public final Class<E> getPersistentClass(){
		return serviceImpClass;
	}
	
	public List<E> findAll(){
		return getDao().findAll();
	}
	
	public E findById(ID id) {
		Optional<E> optional = getDao().findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException("Dado não encontrado!: Id: " + id));
	}
	
	@Transactional
	public E save(E entity) {
		return getDao().save(entity);
	}
	
	@Transactional
	public E merge(E entity) {
		return getDao().save(entity);
	}
	
	@Transactional
	public void delete(ID id) {
		 getDao().delete(Optional.ofNullable(this.findById(id)).get());
	}
}
