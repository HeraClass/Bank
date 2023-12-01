package ProyekAhkir;
import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, String name) {
        super(username, password, name);
        // tambahkan logika konstruktor Admin jika diperlukan
    }
    
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public List<Customer> viewAllCustomers(Bank bank) {
        return bank.getCustomers();
    }

    // method dan atribut lainnya sesuai kebutuhan
}
