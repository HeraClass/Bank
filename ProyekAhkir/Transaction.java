package ProyekAhkir;

public class Transaction {
    private Customer sender;
    private Customer receiver;
    private double amount;

    public Transaction(Customer sender, Customer receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public boolean execute() {
        if (sender.getAccountBalance() >= amount) {
            sender.setAccountBalance(sender.getAccountBalance() - amount);
            receiver.setAccountBalance(receiver.getAccountBalance() + amount);
            sender.getTransactions().add(this);
            return true;
        } else {
            return false;
        }
    }
}
