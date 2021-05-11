package testePratico.ContaPagar.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor@Builder
@Entity
@SequenceGenerator(name="atraso_seq", sequenceName="atraso_sequence", allocationSize = 1)
public class Atraso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator ="atraso_seq")
	@Column
	private Integer id;
	
	@Column
	private Integer qtdDiasAtraso;
	
	@Column
	private Double multa;
	
	@Column 
	private Double jurosDia;
	
	@Column 
	private Double valorMultaJuros;
}
