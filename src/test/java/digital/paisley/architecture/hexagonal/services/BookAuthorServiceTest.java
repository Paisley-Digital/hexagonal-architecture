package digital.paisley.architecture.hexagonal.services;

import digital.paisley.architecture.hexagonal.core.BookAuthorService;
import digital.paisley.architecture.hexagonal.core.BookAuthorServiceImpl;
import digital.paisley.architecture.hexagonal.domain.AuthorDto;
import digital.paisley.architecture.hexagonal.domain.BookAuthorPersistencePort;
import digital.paisley.architecture.hexagonal.domain.BookDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class BookAuthorServiceTest {

    @Mock
    private BookAuthorPersistencePort bookAuthorPersistencePort;

    private BookAuthorService bookAuthorService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        bookAuthorService=new BookAuthorServiceImpl(bookAuthorPersistencePort);
    }

    @Test
    void testGetAllBook() {
        List<BookDto> books = new ArrayList<>();
        List<AuthorDto> authors = new ArrayList<>();
        authors.add(AuthorDto.builder().name("Meysam").build());
        books.add(BookDto.builder().name("Book1").authors(authors).build());

        when(bookAuthorPersistencePort.getAllBook()).thenReturn(books);

        List<BookDto> allBook = bookAuthorService.getAllBook();

        assertTrue(allBook.size() > 0);
    }

}
