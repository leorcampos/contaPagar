package testePratico.ContaPagar.api.domain;

public enum RegraAtraso {

	ATE_TRES(2.0, 0.1),
	SUPERIOR_TRES(3.0, 0.2),
	SUPERIOR_CINCO(5.0, 0.3);

	private final double multa;
	private final double jurosDia;

	RegraAtraso(double multa, double jurosDia) {
		this.multa = multa;
		this.jurosDia = jurosDia;
	}

	public double getMulta() {
		return multa;
	}

	public double getJurosDia() {
		return jurosDia;
	}

}
