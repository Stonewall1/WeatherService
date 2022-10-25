package by.example.weatherservice.service;

import by.example.weatherservice.dao.WeatherDataDao;
import by.example.weatherservice.entity.Location;
import by.example.weatherservice.entity.User;
import by.example.weatherservice.entity.WeatherData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class WeatherService {
    @Qualifier("InMemoryWeatherDataDao")
    private final WeatherDataDao<WeatherData, Long> weatherDataDao;

    public WeatherService(WeatherDataDao<WeatherData, Long> weatherDataDao) {
        this.weatherDataDao = weatherDataDao;
    }

    public WeatherData save(WeatherData weatherData) {
        return weatherDataDao.save(weatherData);
    }

    public Optional<WeatherData> findById(Long id) {
        return weatherDataDao.findById(id);
    }

    public WeatherData findWeatherDataByUserLocation(User user) {
        Location location = user.getLocation();
        WeatherData data = new WeatherData();
        data.setHumidity(new Random().nextDouble() * 100);
        data.setTemperature(new Random().nextDouble() * 50);
        data.setTime(LocalDateTime.now());
        data.setLocation(location);
        weatherDataDao.save(data);
        return data;
    }
}
