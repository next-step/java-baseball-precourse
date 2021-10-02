package junit5.assertion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit5.domain.Book;
import junit5.service.BookService;

@Disabled
public class AssertEqualsTests {

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
	public void assertEqualsWithNoMessage() {
		Book actualBook = bookService.getBookById("1");
		assertEquals("1", actualBook.getBookId());
		assertEquals("Head First Java", actualBook.getTitle());
	}

	@Test
	public void assertEqualsWithMessage() {
		Book actualBook = bookService.getBookById("1");
		assertEquals("1", actualBook.getBookId(), "Book Id didn't match");
		assertEquals("Head First", actualBook.getTitle(), "Book title didn't match");
	}

	@Test
	public void assertEqualsWithMessageSupplier() {
		Book actualBook = bookService.getBookById("1");
		assertEquals("1", actualBook.getBookId(), () -> "Book Id didn't match");
		assertEquals("Head First", actualBook.getTitle(), () -> "Book title didn't match");
	}

}
