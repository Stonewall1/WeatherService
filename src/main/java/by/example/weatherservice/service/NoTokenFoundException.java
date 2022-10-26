package by.example.weatherservice.service;

public class NoTokenFoundException extends Exception {
    @Override
    public String getMessage() {
        return "No token found";
    }
}
