package app.web.pavelk.database4.repo;


import app.web.pavelk.database4.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
