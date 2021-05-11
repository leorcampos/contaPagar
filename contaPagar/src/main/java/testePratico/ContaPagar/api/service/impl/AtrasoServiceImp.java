package testePratico.ContaPagar.api.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;

import testePratico.ContaPagar.api.RegrasCalculoJuros.CalculadoraMultaJuros;
import testePratico.ContaPagar.api.domain.Atraso;
import testePratico.ContaPagar.api.repository.AtrasoRepository;
import testePratico.ContaPagar.api.service.AtrasoService;
import testePratico.ContaPagar.framework.persistencia.Dao;
import testePratico.ContaPagar.framework.service.ServiceImpl;

public class AtrasoServiceImp extends ServiceImpl<Atraso, Integer> implements AtrasoService  {


	@Autowired 
	private AtrasoRepository AtrasoRepository;
	
	public Atraso criarAtraso(LocalDate dataPagamento, LocalDate dataVencimento, double valorOriginal) {
		Atraso atraso = new Atraso();
		if(dataPagamento.isAfter(dataVencimento)) {
			Integer qtdDiasAtraso = Period.between(dataPagamento, dataVencimento).getDays();
			double valorMultaJuros = new CalculadoraMultaJuros().calcular(qtdDiasAtraso, valorOriginal, atraso);
			atraso.setValorMultaJuros(valorMultaJuros);
		}
		
		return atraso;
		
	}
	@Override
	public Dao<Atraso, Integer> getDao() {
		return AtrasoRepository;
	}


}
