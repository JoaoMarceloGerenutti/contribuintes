package entities;

public class Individual extends TaxPayer {

	private Double gastoSaude;
	
	public Individual() {
	}

	public Individual(String nome, Double rendimentoAnual, Double gastoSaude) {
		super(nome, rendimentoAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double taxa() {
		if (super.getRendimentoAnual() < 20000) {
			return super.getRendimentoAnual() * 0.15 - gastoSaude * 0.5;
		} else {
		    return super.getRendimentoAnual() * 0.25 - gastoSaude * 0.5;
		}
	}

}
