package ProyekAhkir;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);


        Admin admin = new Admin("admin", "adminpass", "Admin Name");
        bank.addUser(admin);


        Customer customer1 = new Customer("user1", "pass1", "Denny Mahendra", 50000);
        Customer customer2 = new Customer("user2", "pass2", "Jane Mervina", 50000);
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        User currentUser = null;

        while (true) {
            System.out.println("Selamat datang di Bank Kencana");
            System.out.println("1. Login");
            System.out.println("2. Keluar");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentUser = login(bank, scanner);
                    if (currentUser != null) {
                        if (currentUser instanceof Admin) {
                            adminMenu((Admin) currentUser, bank, scanner);
                        } else if (currentUser instanceof Customer) {
                            customerMenu((Customer) currentUser, bank, scanner);
                        }
                    } else {
                        System.out.println("Login gagal. Coba lagi.");
                    }
                    break;
                case 2:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static User login(Bank bank, Scanner scanner) {
        System.out.print("Masukkan username: ");
        String username = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        User user = bank.authenticateUser(username, password);

        if (user != null) {
            return user;
        } else {
            Admin admin = bank.authenticateAdmin(username, password);
            if (admin != null) {
                return admin;
            } else {
                return null;
            }
        }
    }

    private static void adminMenu(Admin admin, Bank bank, Scanner scanner) {
        System.out.println("Selamat datang, Admin!");
        while (true) {
            System.out.println("1. Tambah Nasabah");
            System.out.println("2. Lihat Semua Nasabah");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(bank, scanner);
                    break;
                case 2:
                    viewAllCustomers(admin, bank);
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void addCustomer(Bank bank, Scanner scanner) {
        System.out.print("Masukkan username nasabah baru: ");
        String newUsername = scanner.next();
        System.out.print("Masukkan password nasabah baru: ");
        String newPassword = scanner.next();
        System.out.print("Masukkan nama nasabah baru: ");
        String newName = scanner.next();
        System.out.print("Masukkan saldo awal nasabah baru: ");
        double initialBalance = scanner.nextDouble();
    
        Customer newCustomer = new Customer(newUsername, newPassword, newName, initialBalance);
        bank.addCustomer(newCustomer);
    
        System.out.println("Nasabah baru berhasil ditambahkan!");
    }
    

    private static void viewAllCustomers(Admin admin, Bank bank) {
        System.out.println("Daftar Semua Nasabah:");
        for (Customer customer : bank.getCustomers()) {
            System.out.println(customer.getUsername() + " - " + customer.getName());
        }
    }

    private static void customerMenu(Customer customer, Bank bank, Scanner scanner) {
        System.out.println("Selamat datang, " + customer.getName() + "!");
        while (true) {
            System.out.println("1. Simpan Uang");
            System.out.println("2. Tarik Uang");
            System.out.println("3. Transfer");
            System.out.println("4. Lihat Saldo");
            System.out.println("5. Logout");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositMoney(customer, scanner);
                    break;
                case 2:
                    withdrawMoney(customer, scanner);
                    break;
                case 3:
                    transferMoney(customer, bank, scanner);
                    break;
                case 4:
                    checkBalance(customer); 
                    break;    
                case 5:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void depositMoney(Customer customer, Scanner scanner) {
        System.out.print("Masukkan jumlah uang yang akan disimpan: ");
        double depositAmount = scanner.nextDouble();
        customer.deposit(depositAmount);
        System.out.println("Uang berhasil disimpan. Saldo saat ini: " + customer.getAccountBalance());
    }

    private static void withdrawMoney(Customer customer, Scanner scanner) {
        double withdrawAmount;
    
        System.out.print("Masukkan jumlah uang yang akan ditarik: ");
    
        withdrawAmount = scanner.nextDouble();
    
        if (customer.getAccountBalance() >= withdrawAmount && withdrawAmount > 0) {
            customer.withdraw(withdrawAmount);
            System.out.println("Uang berhasil ditarik. Saldo saat ini: " + customer.getAccountBalance());
        } else {
            System.out.println("Penarikan gagal. Harap periksa kembali jumlah penarikan atau saldo Anda.");
        }
    }

    private static void checkBalance(Customer customer) {
        System.out.println("Saldo saat ini: " + customer.getAccountBalance());
    }

    private static void transferMoney(Customer customer, Bank bank, Scanner scanner) {
        System.out.print("Masukkan username penerima: ");
        String receiverUsername = scanner.next();
        Customer receiver = bank.findCustomerByUsername(receiverUsername);

        if (receiver != null) {
            System.out.print("Masukkan jumlah uang yang akan ditransfer: ");
            double transferAmount = scanner.nextDouble();
            boolean success = bank.transferMoney(customer, receiver, transferAmount);

            if (success) {
                System.out.println("Transfer berhasil. Saldo saat ini: " + customer.getAccountBalance());
            } else {
                System.out.println("Transfer gagal. Saldo tidak mencukupi.");
            }
        } else {
            System.out.println("Penerima dengan username " + receiverUsername + " tidak ditemukan.");
        }
    }
}
