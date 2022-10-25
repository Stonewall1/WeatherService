package by.example.weatherservice.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface UserDao<T , ID> extends CrudDao<T, ID>{
    Optional<T> findByToken(String token);
    List<T> findAll();
}
