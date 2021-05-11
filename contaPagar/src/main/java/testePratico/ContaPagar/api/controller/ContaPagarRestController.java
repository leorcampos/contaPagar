package testePratico.ContaPagar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testePratico.ContaPagar.api.controller.dto.ContaPagarDTO;
import testePratico.ContaPagar.api.domain.Atraso;
import testePratico.ContaPagar.api.domain.ContaPagar;
import testePratico.ContaPagar.api.mapper.ContaPagarMapper;
import testePratico.ContaPagar.api.service.impl.AtrasoServiceImp;
import testePratico.ContaPagar.api.service.impl.ContaPagarServiceImp;
import testePratico.ContaPagar.framework.service.Service;
import testePratico.ContaPagar.framework.util.ObjectConvert;

@RestController
@RequestMapping("/contaPagar")
public class ContaPagarRestController {

	@Autowired
	private ContaPagarServiceImp contaPagarServiceImp;
	
	@Autowired
	private AtrasoServiceImp atrasoServiceImp;
	
	public static final ContaPagarMapper contaPagarMapper = new ContaPagarMapper();
	
	public Service<ContaPagar, Integer> service() {
		return contaPagarServiceImp;
	}

	@PostMapping
	protected ResponseEntity<?> create(@RequestBody ContaPagarDTO contaPagarDto) {
		ContaPagar contaPagar = contaPagarMapper.toDomain(contaPagarDto);
		Atraso atraso = atrasoServiceImp.criarAtraso(contaPagarDto.getDataPagamento(),
				contaPagarDto.getDataVencimento(), contaPagarDto.getValorOriginal());
		contaPagar.setAtraso(atraso);
		service().save(contaPagar);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaPagarMapper.fromDomain(contaPagar));
	}

	@GetMapping
	public List<ContaPagarDTO> findAll() {
		List<ContaPagarDTO> list =  ObjectConvert.parserListObjeto(service().findAll(), ContaPagarDTO.class);
		
		return (List<ContaPagarDTO>) ResponseEntity.status(HttpStatus.OK).body(list);
	}

}
