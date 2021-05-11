package testePratico.ContaPagar.api.controller.dto;


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
public class AtrasoDTO {

	private Integer id;
	private Integer qtdDiasAtraso;
	private Double multa;
	private Double jurosDia;
	private Double valorMultaJuros;
}
