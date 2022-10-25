package by.example.weatherservice.controller;

import by.example.weatherservice.entity.User;
import by.example.weatherservice.entity.WeatherData;
import by.example.weatherservice.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/current")
    public ResponseEntity<?> currentWeatherByUserLocation(@Valid @RequestBody User user){
        WeatherData weatherDataByUserLocation = weatherService.findWeatherDataByUserLocation(user);
        return new ResponseEntity<>(weatherDataByUserLocation , HttpStatus.ACCEPTED);
    }
}
