package ProyekAhkir;
import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, String name) {
        super(username, password, name);
    }
    
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public List<Customer> viewAllCustomers(Bank bank) {
        return bank.getCustomers();
    }

}
