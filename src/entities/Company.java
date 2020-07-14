package entities;

public class Company extends TaxPayer {

	private Integer numeroDeFuncionarios;
	
	public Company() {
	}

	public Company(String nome, Double rendimentoAnual, Integer numeroDeFuncionarios) {
		super(nome, rendimentoAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	@Override
	public double taxa() {
		if (numeroDeFuncionarios > 10) {
			return super.getRendimentoAnual() * 0.14;
		} else {
		    return super.getRendimentoAnual() * 0.16;
		}
	}

}
