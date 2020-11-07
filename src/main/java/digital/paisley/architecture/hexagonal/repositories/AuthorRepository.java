package digital.paisley.architecture.hexagonal.repositories;

import digital.paisley.architecture.hexagonal.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Long>{
}
