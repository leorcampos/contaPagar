package testePratico.ContaPagar.api.RegrasCalculoJuros;

import testePratico.ContaPagar.api.domain.RegraAtraso;

public class CalculaValorSuperiorTresDias implements RegrasCalculo {
	
	private double ValorPagamento;
	
	public CalculaValorSuperiorTresDias(double valorPagamento) {
		this.ValorPagamento = valorPagamento;
	}
	
	@Override
	public double calculaValorJuros(Integer qtdDiasAtraso) {
		double valorMulta = this.ValorPagamento *  RegraAtraso.SUPERIOR_TRES.getMulta();
		double valorJuros = qtdDiasAtraso * RegraAtraso.SUPERIOR_TRES.getJurosDia();
		return valorMulta + valorJuros;
	}

}
