package cz.upce.fei.nnpiacv.component;

import cz.upce.fei.nnpiacv.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import cz.upce.fei.nnpiacv.repository.UserRepository;

@Component
@Slf4j
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;


    @Override
    public void run(String... args) {
        User user = new User(0L, "admin@upce", "password123");

        if (!userRepository.existsById(user.getId())) {
            log.debug("Admin user created: " + user);
            userRepository.save(user);
        }
    }
}
