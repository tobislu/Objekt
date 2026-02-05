package oving2;

public class Account {
    private double balance = 0.0;
    private double interestRate = 0.0;
    
    public Account(double balance, double interestRate){
        if (interestRate < 0|| balance < 0) {
            throw new IllegalArgumentException("InterestRate er ulovlig");
        }
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double newInterestRate) {
        if (newInterestRate < 0) {
            throw new IllegalArgumentException("Må være mer enn null");
        }
        this.interestRate = newInterestRate;
    }
    
    public void deposit(double s){
        if (s <= 0){
            throw new IllegalArgumentException("InterestRate er ulovlig");
        }
        this.balance += s;
    }

    public void withdraw(double withdrawAmount){
        if (withdrawAmount <= 0) {
            throw new IllegalArgumentException("InterestRate er ulovlig");
        }
        else if (withdrawAmount > this.balance){
            throw new IllegalArgumentException("InterestRate er ulovlig");
        }
        this.balance -= withdrawAmount;
    }

    public void addInterest(){
        this.balance = this.balance * ((this.interestRate/100)+1);
    }
}


// Tilstanden (balance og interestRate) er private og kan kun leses/endres via metodene,
// som validerer input og hindrer ugyldige verdier. Dermed er tilstanden fullt innkapslet.
// Klassen er data-orientert, siden den representerer en konto med egen tilstand og
// oppførsel knyttet direkte til disse dataene, ikke en generell tjeneste.