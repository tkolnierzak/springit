package pl.flutterdeveloper.springit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.flutterdeveloper.springit.domain.Comment;
import pl.flutterdeveloper.springit.domain.Link;
import pl.flutterdeveloper.springit.repository.CommentRepository;
import pl.flutterdeveloper.springit.repository.LinkRepository;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("TomKol", "www.tomkol.pl");
            linkRepository.save(link);

            Comment comment = new Comment("This is awesome!", link);
            commentRepository.save(comment);
            link.addComment(comment);
        };
    }

}
