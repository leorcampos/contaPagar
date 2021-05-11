package testePratico.ContaPagar.api.RegrasCalculoJuros;

import testePratico.ContaPagar.api.domain.RegraAtraso;

public class CalculaValorAteTresDias implements RegrasCalculo {

	private double ValorPagamento;
	
	public CalculaValorAteTresDias(double valorPagamento) {
		this.ValorPagamento = valorPagamento;
	}
	@Override
	public double calculaValorJuros(Integer qtdDiasAtraso) {
		double valorMulta = this.ValorPagamento *  RegraAtraso.ATE_TRES.getMulta();
		double valorJuros = qtdDiasAtraso * RegraAtraso.ATE_TRES.getJurosDia();
		return valorMulta + valorJuros;
	}

}
