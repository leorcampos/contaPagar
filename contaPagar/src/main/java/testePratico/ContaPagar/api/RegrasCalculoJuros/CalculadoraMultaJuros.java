package testePratico.ContaPagar.api.RegrasCalculoJuros;

import testePratico.ContaPagar.api.domain.Atraso;
import testePratico.ContaPagar.api.domain.RegraAtraso;

public class CalculadoraMultaJuros {

	public double calcular(Integer qtdDiasAtraso, double valorOriginal, Atraso atraso) {
		if(qtdDiasAtraso > 5 ) {
			setObjetoAtraso(atraso, RegraAtraso.SUPERIOR_CINCO.getJurosDia(), RegraAtraso.SUPERIOR_CINCO.getMulta(), qtdDiasAtraso);
			return new CalculaValorSuperiorCincoDias(valorOriginal).calculaValorJuros(qtdDiasAtraso);
		}
		if(qtdDiasAtraso > 3 ) {
			setObjetoAtraso(atraso, RegraAtraso.SUPERIOR_TRES.getJurosDia(), RegraAtraso.SUPERIOR_TRES.getMulta(), qtdDiasAtraso);
			return new CalculaValorSuperiorTresDias(valorOriginal).calculaValorJuros(qtdDiasAtraso);
		}
		else {
			setObjetoAtraso(atraso, RegraAtraso.ATE_TRES.getJurosDia(), RegraAtraso.ATE_TRES.getMulta(), qtdDiasAtraso);
			return new CalculaValorAteTresDias(valorOriginal).calculaValorJuros(qtdDiasAtraso);
		}
	}
	
	private void setObjetoAtraso(Atraso atraso, double jurosDia, double multa, Integer qtdDiasAtraso) {
		atraso.setJurosDia(jurosDia);
		atraso.setMulta(multa);
		atraso.setQtdDiasAtraso(qtdDiasAtraso);
	}
}
