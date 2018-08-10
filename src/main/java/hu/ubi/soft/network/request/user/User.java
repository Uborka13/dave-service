package hu.ubi.soft.network.request.user;

public class User {

    private String name;
    private String email;

    private User() {
    }

    public User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
