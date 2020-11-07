package digital.paisley.architecture.hexagonal.repositories;

import digital.paisley.architecture.hexagonal.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long>{
}
