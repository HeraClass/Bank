package ProyekAhkir;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String name;
    private double accountBalance;
    private List<Transaction> transactions;

    public Customer(String username, String password, String name, double initialBalance) {
        super(username, password);
        this.name = name;
        this.accountBalance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        accountBalance += amount;
        Transaction transaction = new Transaction("Deposit", getUsername(), getUsername(), amount, this, this);
        transactions.add(transaction);
    }

    public void withdraw(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            Transaction transaction = new Transaction("Withdrawal", getUsername(), getUsername(), amount, this, this);
            transactions.add(transaction);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + getUsername() + ":");
        for (Transaction transaction : transactions) {
            System.out.println("Type: " + transaction.getType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Timestamp: " + transaction.getTimestamp());
            System.out.println("Sender: " + transaction.getSenderUsername());
            System.out.println("Receiver: " + transaction.getReceiverUsername());
            System.out.println("-----");
        }
    }
}
