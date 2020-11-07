package digital.paisley.architecture.hexagonal.core;

import digital.paisley.architecture.hexagonal.domain.AuthorDto;
import digital.paisley.architecture.hexagonal.domain.BookDto;
import digital.paisley.architecture.hexagonal.domain.BookAuthorPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {

    private BookAuthorPersistencePort bookAuthorPersistencePort;

    public BookAuthorServiceImpl(BookAuthorPersistencePort bookAuthorPersistencePort) {
        this.bookAuthorPersistencePort = bookAuthorPersistencePort;
    }

    @Override
    public void addBook(BookDto bookDto) {
        bookAuthorPersistencePort.addBook(bookDto);
    }

    @Override
    public List<BookDto> getAllBook() {
        return bookAuthorPersistencePort.getAllBook();
    }

    @Override
    public void addAuthor(AuthorDto authorDto) {
        bookAuthorPersistencePort.addAuthor(authorDto);
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        return bookAuthorPersistencePort.getAllAuthor();
    }

}
