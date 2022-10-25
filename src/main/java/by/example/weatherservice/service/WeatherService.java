package by.example.weatherservice.service;

import by.example.weatherservice.dao.WeatherDataDao;
import by.example.weatherservice.entity.WeatherData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
