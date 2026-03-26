package oving7.abstractaccount;

/**
 * A {@code CreditAccount} has in addition to {@code balance} a state for
 * {@code creditLine}, i.e.
 * available credit on the account. This credit line allows the account to be
 * overdrawn (that the
 * balance is negative) within the credit line. If {@link #internalWithdraw()}
 * tries to withdraw
 * more money than is available, taking the credit line into account, an
 * {@code IllegalArgumentException} should be thrown.
 * 
 * @see AbstractAccount
 */
public class CreditAccount extends AbstractAccount {

    private double creditLine;

    /**
     * Initializes a new {@code CreditAccount} with the specified credit line.
     * 
     * @param creditLine the credit line
     * @throws IllegalArgumentException if the credit line is negative
     */
    public CreditAccount(double creditLine) {
        if (creditLine < 0) {
            throw new IllegalArgumentException("Credit line cannot be negative");
        }
        this.creditLine = creditLine;
    }

    @Override
    protected void internalWithdraw(double amount) {
        if (balance - amount < -creditLine) {
            throw new IllegalArgumentException("Withdrawal exceeds credit line");
        }
        balance -= amount;
    }

    /**
     * @return the credit line
     * 
     * @see CreditAccountTest#testCreditLine()
     */
    public double getCreditLine() {
        return creditLine;
    }

    /**
     * Sets the credit line.
     * 
     * @param creditLine the credit line
     * @throws IllegalArgumentException if the credit line is negative
     * @throws IllegalStateException    if the new credit line does not cover the
     *                                  existing balance
     * 
     * @see CreditAccountTest#testCreditLine()
     */
    public void setCreditLine(double creditLine) {
        if (creditLine < 0) {
            throw new IllegalArgumentException("Credit line cannot be negative");
        }
        if (balance < -creditLine) {
            throw new IllegalStateException("New credit line does not cover current balance");
        }
        this.creditLine = creditLine;
    }
}