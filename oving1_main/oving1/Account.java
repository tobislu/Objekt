package oving1;

public class Account {
    private double balance = 0.0;
    private double interestRate = 0.0;

    public Account(){
        
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
        }
    }

    public void addInterest() {
        balance = balance*(1+(interestRate/100));
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double newIterestRate) {
        interestRate = newIterestRate;
    }

    public static void main(String[] args) {
        Account myAccount = new Account();
        myAccount.deposit(10);
        System.out.println(myAccount);
        Account myAccount2 = new Account();
        System.out.println(myAccount2);
    }

    public String toString() {
        return String.format("Konto: saldo=%s, rente=%s", balance, interestRate);
    }
}
