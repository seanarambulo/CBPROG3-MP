public class AdminEditUser {

    private String email;
    private String username;

    // Constructor
    public AdminEditUser(String email, String username) {
        this.email = email;
        this.username = username;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AdminEditUser{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
