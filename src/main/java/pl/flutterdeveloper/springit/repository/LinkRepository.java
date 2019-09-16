package pl.flutterdeveloper.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flutterdeveloper.springit.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
