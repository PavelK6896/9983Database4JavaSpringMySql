package app.web.pavelk.database4.service;

import app.web.pavelk.database4.repo.TopicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepo topicRepo;

    @Transactional
    public Boolean showBooks() {
        topicRepo.findAll().forEach(f -> System.out.println(f.getBooks()));
        return true;
    }

}
