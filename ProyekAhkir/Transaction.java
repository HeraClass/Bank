package ProyekAhkir;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private String senderUsername;
    private String receiverUsername;
    private double amount;
    private Customer sender;
    private Customer receiver;
    private LocalDateTime timestamp;

    public Transaction(String type, String senderUsername, String receiverUsername, double amount, Customer sender, Customer receiver) {
        this.type = type;
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = LocalDateTime.now();
    }

    public boolean execute() {
        if (sender != null && receiver != null && sender.getAccountBalance() >= amount) {
            // Update saldo pengirim dan penerima
            sender.withdraw(amount);
            receiver.deposit(amount);

            // Tambahkan transaksi ke histori pengirim
            sender.getTransactions().add(this);

            return true;
        } else {
            return false;
        }
    }

    public String getType() {
        return type;
    }

    public Customer getSender() {
        return sender;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
