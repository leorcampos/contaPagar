package testePratico.ContaPagar.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import testePratico.ContaPagar.api.domain.ContaPagar;
import testePratico.ContaPagar.api.repository.ContaPagarRepository;
import testePratico.ContaPagar.api.service.ContaPagarService;
import testePratico.ContaPagar.framework.persistencia.Dao;
import testePratico.ContaPagar.framework.service.ServiceImpl;

public class ContaPagarServiceImp extends ServiceImpl<ContaPagar, Integer> implements ContaPagarService {

	@Autowired 
	private ContaPagarRepository contaPagarRepository;
	
	@Override
	public Dao<ContaPagar, Integer> getDao() {
		return contaPagarRepository;
	}

}
