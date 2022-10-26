package by.example.weatherservice.dto;

import javax.validation.constraints.NotBlank;

public class WeatherDataDto {
    @NotBlank(message = "Field cant be empty")
    private String country;
    @NotBlank(message = "Field cant be empty")
    private String city;

    private int daysCount;

    public WeatherDataDto() {
    }

    public WeatherDataDto(String country, String city, int daysCount) {
        this.country = country;
        this.city = city;
        this.daysCount = daysCount;
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

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }
}
