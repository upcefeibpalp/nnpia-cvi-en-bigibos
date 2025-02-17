package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private Map<Long, User> users = new HashMap<Long, User>();

    @PostConstruct
    public void init() {
        users.put(0L, new User(0L, "John", "Doe"));
        users.put(1L, new User(1L, "Martin", "Seidl"));
    }


    public List<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    public User findUser(long id) {
        User user = users.get(id);

        logger.info("User created: " + user);

        return user;
    }
}
