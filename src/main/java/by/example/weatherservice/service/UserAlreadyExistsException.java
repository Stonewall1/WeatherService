package by.example.weatherservice.service;

public class UserAlreadyExistsException extends Exception {
    @Override
    public String getMessage() {
        return "User already in base";
    }
}
