package pl.flutterdeveloper.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flutterdeveloper.springit.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
