package oving7.abstractaccount;

/**
 * A {@code SavingsAccount} can only have a positive balance. In addition, the
 * account has
 * withdrawal restrictions. A {@code SavingsAccount} has {@code x} number of
 * {@code withdrawals}. If
 * you want to withdraw money after all withdrawals have been used up, the
 * balance should be charged
 * a {@code fee}. If the balance is too low to cover the fee, an
 * {@code IllegalArgumentException}
 * should be thrown.
 * 
 * @see AbstractAccount
 */
public class SavingsAccount extends AbstractAccount {

    private int withdrawals;
    private double fee;

    /**
     * Initializes a new {@code SavingsAccount} with the specified number of
     * withdrawals and fee.
     * 
     * @param withdrawals the number of withdrawals
     * @param fee         the fee
     * @throws IllegalArgumentException if the number of withdrawals or the fee is
     *                                  negative
     */
    public SavingsAccount(int withdrawals, double fee) {
        if (withdrawals < 0 || fee < 0) {
            throw new IllegalArgumentException("Withdrawals and fee cannot be negative");
        }
        this.withdrawals = withdrawals;
        this.fee = fee;
    }

    @Override
    protected void internalWithdraw(double amount) {
        if (withdrawals > 0) {
            if (amount > balance) {
                throw new IllegalArgumentException("Not enough money in account");
            }
            balance -= amount;
            withdrawals--;
        } else {
            if (amount + fee > balance) {
                throw new IllegalArgumentException("Not enough money to cover withdrawal and fee");
            }
            balance -= (amount + fee);
        }
    }
}