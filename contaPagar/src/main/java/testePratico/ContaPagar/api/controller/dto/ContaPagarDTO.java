package testePratico.ContaPagar.api.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaPagarDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3829872179861403808L;
	
	private Integer id;
	
	private String nome;
	
	private Long valorOriginal;
	
	private LocalDate dataVencimento;
	
	private LocalDate dataPagamento;
	
	private AtrasoDTO atraso;

}
