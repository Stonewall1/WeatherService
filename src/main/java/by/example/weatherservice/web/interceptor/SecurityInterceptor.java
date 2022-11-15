package by.example.weatherservice.web.interceptor;

import by.example.weatherservice.dao.InMemoryUserDao;
import by.example.weatherservice.exceptions.NoTokenFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    private final InMemoryUserDao inMemoryUserDao;

    public SecurityInterceptor(InMemoryUserDao inMemoryUserDao) {
        this.inMemoryUserDao = inMemoryUserDao;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Token");
        if (inMemoryUserDao.findByToken(token).isPresent()) {
            return true;
        } else {
            throw new NoTokenFoundException();
        }
    }
}
