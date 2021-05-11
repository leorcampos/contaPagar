package testePratico.ContaPagar.api.mapper;


import testePratico.ContaPagar.api.controller.dto.ContaPagarDTO;
import testePratico.ContaPagar.api.domain.ContaPagar;

public class ContaPagarMapper implements DomainMapper<ContaPagar, ContaPagarDTO>{

	AtrasoMapper atrasoMapper = new AtrasoMapper();
	
	@Override
	public ContaPagar toDomain(ContaPagarDTO contaPagarDto) {
		
		ContaPagar contaPagar = new ContaPagar();
		return updateDomain(contaPagar, contaPagarDto);
	}

	@Override
	public ContaPagar updateDomain(ContaPagar contaPagar, ContaPagarDTO contaPagarDto) {
		
		contaPagar.setId(contaPagarDto.getId());
		contaPagar.setNome(contaPagarDto.getNome());
		contaPagar.setValorOriginal(contaPagarDto.getValorOriginal());
		contaPagar.setDataPagamento(contaPagarDto.getDataPagamento());
		contaPagar.setDataVencimento(contaPagarDto.getDataVencimento());
		contaPagar.setAtraso(atrasoMapper.toDomain(contaPagarDto.getAtraso()));
		

		return contaPagar;
	}

	@Override
	public ContaPagarDTO fromDomain(ContaPagar contaPagar) {
		ContaPagarDTO contaPagarDTO = new ContaPagarDTO();
		
		contaPagarDTO.setId(contaPagar.getId());
		contaPagarDTO.setNome(contaPagar.getNome());
		contaPagarDTO.setValorOriginal(contaPagar.getValorOriginal());
		contaPagarDTO.setDataPagamento(contaPagar.getDataPagamento());
		contaPagarDTO.setDataVencimento(contaPagar.getDataVencimento());
		contaPagarDTO.setAtraso(atrasoMapper.fromDomain(contaPagar.getAtraso()));
		
		return contaPagarDTO;
	}

	
}
