package ProyekAhkir;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;
    private List<User> users;

    public Bank() {
        this.customers = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        users.add(customer);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Customer findCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

public Admin authenticateAdmin(String username, String password) {
    for (User user : users) {
        if (user instanceof Admin && user.getUsername().equals(username)) {
            if (((Admin) user).getPassword().equals(password)) {
                return (Admin) user;
            }
        }
    }
    return null;
}

    public boolean transferMoney(Customer sender, Customer receiver, double amount) {
        Transaction transaction = new Transaction(sender, receiver, amount);
        return transaction.execute();
    }
}
