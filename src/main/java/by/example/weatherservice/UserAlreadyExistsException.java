package by.example.weatherservice;

public class UserAlreadyExistsException extends Exception {
    @Override
    public String getMessage() {
        return "User already in base";
    }
}
