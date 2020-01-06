
public class MortgageCalculator {
	private final static byte MONTHS_IN_YEAR = 12;
	private final static byte PERCENT = 100;
	private int principal;
	private float annualInterest;
	private int years;

	public MortgageCalculator(int principal, float annualInterest, int years) {
		// super();
		this.principal = principal;
		this.annualInterest = annualInterest;
		this.years = years;
	}

	public double calculateBalance(short numberOfPaymentsMade) {
		double balance;

		float monthlyInterest = getMonthlyInterest();
		float numberOfPayments = getNumberOfPayments();
		balance = principal
				* (Math.pow(1 + monthlyInterest, numberOfPayments)
						- Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

		return balance;
	}

	public double calculateMortgage() {

		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		double mortgage;

		float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
		short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
		mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

		return mortgage;
	}

	public double[] getRemainingBalances() {
		double[] balances = new double[getNumberOfPayments()];
		for (short month = 1; month <= balances.length; month++)
			balances[month - 1] = calculateBalance(month);

		return balances;
	}

	/*
	 * public int getYears() { return years; }
	 */

	private int getNumberOfPayments() {
		return years * MONTHS_IN_YEAR;
	}

	private float getMonthlyInterest() {
		return annualInterest / PERCENT / MONTHS_IN_YEAR;
	}
}
