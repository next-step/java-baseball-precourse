package junit5.assertion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit5.BookNotFoundException;
import junit5.domain.Book;
import junit5.service.BookService;

@Disabled
public class AssertThrowsTests {

	private BookService bookService;
	List<Book> books;

	@BeforeEach
	public void init() {
		bookService = new BookService();
		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		books = bookService.books();
	}

	@Test
	public void assertThrowsWithNoMessage() {
		assertThrows(BookNotFoundException.class, () -> {
			Book book = bookService.getBookById("3");
		});
	}

	@Test
	public void assertThrowsWithMessageSupplier() {
		assertThrows(BookNotFoundException.class, () -> {
			Book book = bookService.getBookById("1");
		}, () -> "Expected BookNotFoundException");
	}
}
