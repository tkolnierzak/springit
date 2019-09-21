package pl.flutterdeveloper.springit.service;

import org.springframework.stereotype.Service;
import pl.flutterdeveloper.springit.domain.Comment;
import pl.flutterdeveloper.springit.repository.CommentRepository;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
