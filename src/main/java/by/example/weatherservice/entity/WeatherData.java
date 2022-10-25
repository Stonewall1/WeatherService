package by.example.weatherservice.entity;

import java.time.LocalDateTime;

public class WeatherData {
    private long id;
    private double temperature;
    private double humidity;
    private LocalDateTime time;
    private Location location;

    public WeatherData() {
    }

    public WeatherData(long id, double temperature, double humidity, LocalDateTime time, Location location) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.time = time;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", time=" + time +
                ", location=" + location +
                '}';
    }
}
