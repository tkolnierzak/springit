package pl.flutterdeveloper.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flutterdeveloper.springit.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
