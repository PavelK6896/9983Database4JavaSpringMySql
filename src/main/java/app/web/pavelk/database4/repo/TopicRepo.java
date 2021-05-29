package app.web.pavelk.database4.repo;


import app.web.pavelk.database4.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic, Integer> {

}
