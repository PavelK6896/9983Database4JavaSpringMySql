package app.web.pavelk.database4.service;


import app.web.pavelk.database4.model.Book;
import app.web.pavelk.database4.model.Topic;
import app.web.pavelk.database4.repo.BookRepo;
import app.web.pavelk.database4.repo.TopicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MainService implements CommandLineRunner {

    private Scanner scanner = new Scanner(System.in);
    private final BookRepo bookRepo;
    private final TopicRepo topicRepo;
    private final TopicService topicService;

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            TimeUnit.MILLISECONDS.sleep(500);
            String next = scanner.next();

            if (next.equals("1")) {
                System.out.println(bookRepo.findAll());
            } else if (next.equals("2")) {
                System.out.println(topicRepo.findAll());
            } else if (next.equals("3")) {
                topicRepo.findById(1).ifPresentOrElse(f ->
                                bookRepo.save(Book.builder().topicId(f.getId()).name("b" + ThreadLocalRandom.current().nextInt()).build()),
                        () -> {
                            Topic save = topicRepo.save(Topic.builder().name("t" + ThreadLocalRandom.current().nextInt()).build());
                            bookRepo.save(Book.builder().topicId(save.getId()).name("b" + ThreadLocalRandom.current().nextInt()).build());
                        }
                );
            } else if (next.equals("4")) {
                topicRepo.save(Topic.builder().name("t" + ThreadLocalRandom.current().nextInt()).build());
            } else if (next.equals("5")) {
                topicService.showBooks();
            } else if (next.equals("0")) {
                break;
            }
        }
    }


}
