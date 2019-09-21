package pl.flutterdeveloper.springit.service;

import org.springframework.stereotype.Service;
import pl.flutterdeveloper.springit.domain.Vote;
import pl.flutterdeveloper.springit.repository.VoteRepository;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }


    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
}
