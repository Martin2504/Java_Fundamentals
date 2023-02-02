package Chapter_44_TestingUsingJUnit;
import Chapter_10_ObjectOrientedThinking.Loan;

import org.junit.*;

import static org.junit.Assert.*;

public class LoanTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPaymentMethods() {
        double annualInterestRate = 2.5;
        int numberOfYears = 5;
        double loanAmount = 1000;
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);            // creates an instance of Loan
        assertTrue(loan.getMonthlyPayment() == getMonthlyPayment(annualInterestRate, numberOfYears, loanAmount));
        assertTrue(loan.getTotalPayment() == getTotalPayment(annualInterestRate, numberOfYears, loanAmount));
    }

    /** Find monthly payment */
    private double getMonthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /** Find total payment */
    public double getTotalPayment(double annualInterestRate, int numberOfYears, double loanAmount) {
        return getMonthlyPayment(annualInterestRate, numberOfYears, loanAmount) * numberOfYears * 12;
    }
}