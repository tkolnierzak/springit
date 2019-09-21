package pl.flutterdeveloper.springit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.flutterdeveloper.springit.domain.User;
import pl.flutterdeveloper.springit.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user){
        return user;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users){
        for(User user : users){
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }
}
