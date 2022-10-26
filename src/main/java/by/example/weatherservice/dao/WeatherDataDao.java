package by.example.weatherservice.dao;

import org.springframework.stereotype.Component;

@Component
public interface WeatherDataDao<T , ID> extends CrudDao<T, ID> {
}
