package by.example.weatherservice.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    private long id;
    private String token;
    @NotBlank(message = "Field cant be empty")
    private String username;
    @NotBlank(message = "Field cant be empty")
    @Size(min = 3, message = "Minimum size is 3")
    private String password;
    private Location location;

    public User() {
    }

    public User(long id, String token, String username, String password, Location location) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.password = password;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location=" + location +
                '}';
    }
}
