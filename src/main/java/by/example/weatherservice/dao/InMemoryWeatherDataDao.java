package by.example.weatherservice.dao;

import by.example.weatherservice.entity.WeatherData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryWeatherDataDao implements WeatherDataDao<WeatherData , Long> {

    private final List<WeatherData> weatherDataList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();
    @Override
    public WeatherData save(WeatherData weatherData) {
       weatherData.setId(idGenerator.incrementAndGet());
       weatherDataList.add(weatherData);
       return weatherData;
    }

    @Override
    public Optional<WeatherData> findById(Long id) {
       return weatherDataList.stream().filter(weatherData -> weatherData.getId() == id).findFirst();
    }
}
