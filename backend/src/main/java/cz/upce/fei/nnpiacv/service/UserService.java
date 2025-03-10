package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User deleteUser(Long id) {

        userRepository.deleteById(id);

        return null;
    }

    public Collection<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(Long id) {
        User user = userRepository.findById(id).get();
        log.debug("Ziskan uzivatel: " + user);

        return user;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
