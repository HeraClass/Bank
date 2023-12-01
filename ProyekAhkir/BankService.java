package ProyekAhkir;

import java.util.Scanner;

public class BankService {
    private Bank bank;

    public BankService(Bank bank) {
        this.bank = bank;
    }

    public void executeTransaction() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Masukkan username pengirim: ");
            String senderUsername = scanner.next();

            System.out.println("Masukkan username penerima: ");
            String receiverUsername = scanner.next();

            System.out.println("Masukkan jumlah uang yang akan ditransfer: ");
            double amount = scanner.nextDouble();

            Customer sender = bank.findCustomerByUsername(senderUsername);
            Customer receiver = bank.findCustomerByUsername(receiverUsername);

            if (sender != null && receiver != null) {
                Transaction transaction = new Transaction("transfer", sender.getUsername(), receiver.getUsername(), amount, sender, receiver);

                if (transaction.execute()) {
                    System.out.println("Transfer berhasil. Saldo pengirim saat ini: " + sender.getAccountBalance());
                } else {
                    System.out.println("Transfer gagal. Saldo tidak mencukupi.");
                }
            } else {
                System.out.println("Pengirim atau penerima tidak ditemukan.");
            }
        }
    }
}
