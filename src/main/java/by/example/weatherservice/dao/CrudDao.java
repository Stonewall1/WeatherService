package by.example.weatherservice.dao;

import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface CrudDao<T, ID> {
    T save(T element);

    Optional<T> findById(ID id);
}
