package digital.paisley.architecture.hexagonal.repositories;

import digital.paisley.architecture.hexagonal.domain.AuthorDto;
import digital.paisley.architecture.hexagonal.domain.BookDto;
import digital.paisley.architecture.hexagonal.domain.BookAuthorPersistencePort;
import digital.paisley.architecture.hexagonal.entities.Author;
import digital.paisley.architecture.hexagonal.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookAuthorAdapter implements BookAuthorPersistencePort {

    final private BookRepository bookRepository;
    final private AuthorRepository authorRepository;

    public BookAuthorAdapter(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void addBook(BookDto bookDto) {
        Book book = mapBookDtoToBook(bookDto);
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> getAllBook() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapBookToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addAuthor(AuthorDto authorDto) {
        Author author = mapAuthorDtoToAuthor(authorDto);
        authorRepository.save(author);
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        return authorRepository.findAll()
                .stream()
                .map(this::mapAuthorToAuthorDto)
                .collect(Collectors.toList());
    }

    private BookDto mapBookToBookDto(Book book) {
        return BookDto.builder()
                .name(book.name)
                .authors(book.authors.stream().map(this::mapAuthorToAuthorDto).collect(Collectors.toList()))
                .build();
    }

    private Book mapBookDtoToBook(BookDto bookDto) {
        return Book.builder()
                .name(bookDto.name)
                .authors(bookDto.authors.stream().map(this::mapAuthorDtoToAuthor).collect(Collectors.toList()))
                .build();
    }

    private AuthorDto mapAuthorToAuthorDto(Author author) {
        return AuthorDto.builder()
                .name(author.name)
                .build();
    }

    private Author mapAuthorDtoToAuthor(AuthorDto authorDto) {
        return Author.builder()
                .name(authorDto.name)
                .build();
    }

}
