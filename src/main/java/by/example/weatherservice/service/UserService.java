package by.example.weatherservice.service;

import by.example.weatherservice.exceptions.UserAlreadyExistsException;
import by.example.weatherservice.dao.UserDao;
import by.example.weatherservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao<User, Long> userDao;

    public UserService(UserDao<User, Long> userDao) {
        this.userDao = userDao;
    }

    public Optional<User> save(User user) {
        for (User u : findAll()) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new UserAlreadyExistsException();
            }
        }
        userDao.save(user);
        return Optional.of(user);
    }

    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    public Optional<User> findByToken(String token) {
        return userDao.findByToken(token);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
