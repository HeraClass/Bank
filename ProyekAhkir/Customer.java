package ProyekAhkir;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String name;
    private double accountBalance;
    private List<Transaction> transactions;

    public Customer(String username, String password, String name, double accountBalance) {
        super(username, password);
        this.name = name;
        this.accountBalance = accountBalance;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println("Penarikan berhasil. Saldo saat ini: " + accountBalance);
        } else {
            System.out.println("Penarikan gagal. Harap periksa kembali jumlah penarikan atau saldo Anda.");
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    
}
