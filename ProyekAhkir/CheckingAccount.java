package ProyekAhkir;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdrawWithOverdraft(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            withdraw(amount);
        }
    }
}
