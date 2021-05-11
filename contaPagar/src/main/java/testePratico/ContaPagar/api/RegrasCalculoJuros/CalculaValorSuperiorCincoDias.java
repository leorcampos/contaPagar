package testePratico.ContaPagar.api.RegrasCalculoJuros;

import testePratico.ContaPagar.api.domain.RegraAtraso;

public class CalculaValorSuperiorCincoDias implements RegrasCalculo {

	private double ValorPagamento;

	public CalculaValorSuperiorCincoDias(double valorPagamento) {
		this.ValorPagamento = valorPagamento;
	}

	@Override
	public double calculaValorJuros(Integer qtdDiasAtraso) {
		double valorMulta = this.ValorPagamento *  RegraAtraso.SUPERIOR_CINCO.getMulta();
		double valorJuros = qtdDiasAtraso * RegraAtraso.SUPERIOR_CINCO.getJurosDia();
		return valorMulta + valorJuros;

	}

}
