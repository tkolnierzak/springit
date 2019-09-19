package pl.flutterdeveloper.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flutterdeveloper.springit.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
