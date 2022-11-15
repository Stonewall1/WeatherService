package by.example.weatherservice.dao;

import java.util.List;
import java.util.Optional;

public interface UserDao<T, ID> extends CrudDao<T, ID> {
    Optional<T> findByToken(String token);

    List<T> findAll();
}
