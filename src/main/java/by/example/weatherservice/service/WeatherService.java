package by.example.weatherservice.service;

import by.example.weatherservice.dao.WeatherDataDao;
import by.example.weatherservice.dto.WeatherDataDto;
import by.example.weatherservice.entity.Location;
import by.example.weatherservice.entity.User;
import by.example.weatherservice.entity.WeatherData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class WeatherService {
    @Qualifier("inMemoryWeatherDataDao")
    private final WeatherDataDao<WeatherData, Long> weatherDataDao;

    public WeatherService(WeatherDataDao<WeatherData, Long> weatherDataDao) {
        this.weatherDataDao = weatherDataDao;
    }

    public Optional<WeatherData> save(WeatherData weatherData) {
        return weatherDataDao.save(weatherData);
    }

    public Optional<WeatherData> findById(Long id) {
        return weatherDataDao.findById(id);
    }

    private WeatherData weatherDataCreation() {
        WeatherData data = new WeatherData();
        data.setHumidity(new Random().nextDouble() * 100);
        data.setTemperature(new Random().nextDouble() * 50);
        return data;
    }

    public WeatherData findWeatherDataByUserLocation(User user) {
        WeatherData data = weatherDataCreation();
        data.setTime(LocalDateTime.now());
        data.setLocation(user.getLocation());
        save(data);
        return data;
    }

    public WeatherData findWeatherDataByAnyLocation(Location location) {
        WeatherData data = weatherDataCreation();
        data.setTime(LocalDateTime.now());
        data.setLocation(location);
        save(data);
        return data;
    }

    public List<WeatherData> weatherForNDays(WeatherDataDto dto) {
        List<WeatherData> list = new ArrayList<>();
        Location loc = new Location(dto.getCountry(), dto.getCity());
        for (int i = 1; i <= dto.getDaysCount(); i++) {
            WeatherData data = weatherDataCreation();
            data.setTime(LocalDateTime.now().plusDays(i));
            data.setLocation(loc);
            list.add(data);

            save(data);
        }
        return list;
    }
}
