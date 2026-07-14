package refactoring;

public class User {
    private String email;
    private int status;

    public User(String email, int status) {
        this.email = email;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }
}