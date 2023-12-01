package ProyekAhkir;

public class BankService {
    public void transferMoney(Customer sender, Customer receiver, double amount) {
        Transaction transaction = new Transaction(sender, receiver, amount);
        transaction.execute();
    }
}
