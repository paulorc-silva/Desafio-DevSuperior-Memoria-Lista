package br.com.devsuperior.entities;

public class TaxPayer {
	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double salaryTax = 0.0;
		double monthlySalary = salaryIncome / 12;

		if (monthlySalary < 3000) {
			salaryTax = 0.0;
		} else if (monthlySalary >= 3000 && monthlySalary < 5000) {
			salaryTax = salaryIncome * 0.1;
		} else if (monthlySalary >= 5000) {
			salaryTax = salaryIncome * 0.2;
		}

		return salaryTax;
	}

	public double servicesTax() {
		return (serviceIncome > 0.0) ? serviceIncome * 0.15 : 0.0;
	}

	public double capitalTax() {
		return (capitalIncome > 0.0) ? capitalIncome * 0.2 : 0.0;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double maximumDeductible = grossTax() * 0.3;
		double deductibleExpenses = healthSpending + educationSpending;
		return (deductibleExpenses < maximumDeductible) ? deductibleExpenses : maximumDeductible;
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}
}
