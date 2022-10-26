package by.example.weatherservice.web.controller;

import by.example.weatherservice.dto.WeatherDataDto;
import by.example.weatherservice.entity.Location;
import by.example.weatherservice.entity.User;
import by.example.weatherservice.entity.WeatherData;
import by.example.weatherservice.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/currentWeather")
    public ResponseEntity<?> currentWeatherByUserLocation(@Valid @RequestBody User user) {
        WeatherData weatherDataByUserLocation = weatherService.findWeatherDataByUserLocation(user);
        return new ResponseEntity<>(weatherDataByUserLocation, HttpStatus.ACCEPTED);
    }

    @GetMapping("/anyLocation")
    public ResponseEntity<?> currentWeatherByAnyLocation(@Valid @RequestBody Location location) {
        WeatherData weatherDataByAnyLocation = weatherService.findWeatherDataByAnyLocation(location);
        return new ResponseEntity<>(weatherDataByAnyLocation, HttpStatus.ACCEPTED);
    }
    @GetMapping("/nDays")
    public ResponseEntity<?> weatherForNextNDays(@Valid @RequestBody WeatherDataDto weatherDataDto){
        List<WeatherData> weatherData = weatherService.weatherForNDays(weatherDataDto);
        return new ResponseEntity<>(weatherData , HttpStatus.ACCEPTED);
    }
}
