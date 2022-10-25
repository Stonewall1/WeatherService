package by.example.weatherservice.entity;

import javax.validation.constraints.NotBlank;

public class Location {
    @NotBlank(message = "Field cant be empty")
    private String country;
    @NotBlank(message = "Field cant be empty")
    private String city;

    public Location() {
    }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
