package pl.flutterdeveloper.springit.service;

import org.springframework.stereotype.Service;
import pl.flutterdeveloper.springit.domain.Link;
import pl.flutterdeveloper.springit.repository.LinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> findAll(){
        return linkRepository.findAll();
    }

    public Optional<Link> findById(Long id){
        return linkRepository.findById(id);
    }

    public Link save(Link link){
        return linkRepository.save(link);
    }
}
