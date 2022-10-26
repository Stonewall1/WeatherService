package by.example.weatherservice;

public class NoTokenFoundException extends Exception {
    @Override
    public String getMessage() {
        return "No token found";
    }
}
