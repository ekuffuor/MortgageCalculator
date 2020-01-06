public class Main {

	public static void main(String[] args) {
		int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
		float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);
		int years = (int) Console.readNumber("Period (Years): ", 1, 10);

		MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
		MortgageReport report = new MortgageReport(calculator);
		report.printMortgage();
		report.printPaymentSchedule();

		// MortgageReport.printMortgage(principal, annualInterest, years);
		// MortgageReport.printPaymentSchedule(principal, annualInterest, years);
	}
}
