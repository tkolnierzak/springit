package pl.flutterdeveloper.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flutterdeveloper.springit.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
