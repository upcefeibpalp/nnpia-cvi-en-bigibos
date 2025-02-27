package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Collection<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(long id) {
        Optional<User> user = userRepository.findById(id);
        log.debug("Ziskan uzivatel: " + user.get());

        return user.get();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
