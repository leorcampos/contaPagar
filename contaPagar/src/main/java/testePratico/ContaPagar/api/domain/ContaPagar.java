package testePratico.ContaPagar.api.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GenerationType;

@Data
@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
@SequenceGenerator(name="conta_pagar_seq", sequenceName="conta_pagar_sequence", allocationSize = 1)
public class ContaPagar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8565096379794689711L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator ="conta_pagar_seq")
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private Long valorOriginal;
	
	@Column
	private LocalDate dataPagamento;
	
	@Column 
	private LocalDate dataVencimento;
	
	@ManyToOne 
	private Atraso atraso;
}
