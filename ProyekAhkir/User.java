package ProyekAhkir;

public class User {
    private String username;
    private String password;
    private String name;

    // Existing constructor
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // New constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String name() {
        return name;
    }

    // Getter and setter methods for 'password' and 'name' if needed
}
