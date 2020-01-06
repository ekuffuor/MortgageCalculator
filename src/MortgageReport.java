import java.text.NumberFormat;

public class MortgageReport {

	private final NumberFormat currency;
	private MortgageCalculator calculator;

	public MortgageReport(MortgageCalculator calculator) {
		// super();
		this.calculator = calculator;
		currency = NumberFormat.getCurrencyInstance();
	}

	public void printPaymentSchedule() {
		System.out.println();
		System.out.println("PAYMENT SCHEDULE");
		System.out.println("----------------");
		for (double balance : calculator.getRemainingBalances())
			System.out.println(currency.format(balance));

		/*
		 * for (short month = 1; month <= calculator.getYears() *
		 * MortgageCalculator.MONTHS_IN_YEAR; month++) { double balance =
		 * calculator.calculateBalance(month); String balanceFormatted =
		 * NumberFormat.getCurrencyInstance().format(balance);
		 * System.out.println(balanceFormatted); }
		 */
	}

	public void printMortgage() {
		double mortgage = calculator.calculateMortgage();
		String mortgageFormatted = currency.format(mortgage);
		System.out.println();
		System.out.println("MORTGAGE");
		System.out.println("--------");
		System.out.println("Monthly Payments: " + mortgageFormatted);
	}
}
