package by.example.weatherservice.dao;

import by.example.weatherservice.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Component("InMemoryUserDao")
public class InMemoryUserDao implements UserDao<User, Long> {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        user.setToken(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
       return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public Optional<User> findByToken(String token) {
        return users.stream().filter(user -> user.getToken().equals(token)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
