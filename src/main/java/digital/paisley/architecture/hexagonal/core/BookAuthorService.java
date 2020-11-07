package digital.paisley.architecture.hexagonal.core;

import digital.paisley.architecture.hexagonal.domain.AuthorDto;
import digital.paisley.architecture.hexagonal.domain.BookDto;

import java.util.List;

public interface BookAuthorService {

    void addBook(BookDto bookDto);
    List<BookDto> getAllBook();

    void addAuthor(AuthorDto authorDto);
    List<AuthorDto> getAllAuthor();

}
