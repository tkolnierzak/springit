package pl.flutterdeveloper.springit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.flutterdeveloper.springit.domain.User;
import pl.flutterdeveloper.springit.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private RoleService roleService;
    private final MailService mailService;

    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mailService = mailService;
        this.encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setEnabled(false);
        user.setPassword(secret);
        user.setConfirmPassword(secret);
        user.addRole(roleService.findByName("ROLE_USER"));
        user.setActivationCode(UUID.randomUUID().toString());
        save(user);
        sendActivationEmail(user);
        return user;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    private void sendActivationEmail(User user) {
        mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user) {
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode) {
        return userRepository.findByEmailAndActivationCode(email,activationCode);
    }

    @Transactional
    public void saveUsers(User... users){
        for(User user : users){
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }
}
