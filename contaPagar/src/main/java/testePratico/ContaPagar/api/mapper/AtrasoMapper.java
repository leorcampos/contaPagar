package testePratico.ContaPagar.api.mapper;

import testePratico.ContaPagar.api.controller.dto.AtrasoDTO;
import testePratico.ContaPagar.api.domain.Atraso;

public class AtrasoMapper implements DomainMapper<Atraso, AtrasoDTO> {

	@Override
	public Atraso toDomain(AtrasoDTO AtrasoDto) {
		Atraso atraso = new Atraso();
		return updateDomain(atraso, AtrasoDto);
	}

	@Override
	public Atraso updateDomain(Atraso atraso, AtrasoDTO atrasoDto) {
		
		atraso.setId(atrasoDto.getId());
		atraso.setQtdDiasAtraso(atrasoDto.getQtdDiasAtraso());
		atraso.setMulta(atrasoDto.getMulta());
		atraso.setJurosDia(atrasoDto.getJurosDia());
		atraso.setValorMultaJuros(atrasoDto.getValorMultaJuros());

		return atraso;
	}

	@Override
	public AtrasoDTO fromDomain(Atraso atraso) {

		AtrasoDTO atrasoDTO = new AtrasoDTO();
		
		atrasoDTO.setId(atraso.getId());
		atrasoDTO.setQtdDiasAtraso(atraso.getQtdDiasAtraso());
		atrasoDTO.setMulta(atraso.getMulta());
		atrasoDTO.setJurosDia(atraso.getJurosDia());
		atrasoDTO.setValorMultaJuros(atraso.getValorMultaJuros());
		
		return atrasoDTO;
	}

}
