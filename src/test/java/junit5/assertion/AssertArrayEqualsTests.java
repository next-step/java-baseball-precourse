package junit5.assertion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit5.domain.Book;
import junit5.service.BookService;

@Disabled
public class AssertArrayEqualsTests {

	private BookService bookService;
	List<Book> books;

	@BeforeEach
	public void init() {
		bookService = new BookService();

		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");
		Book headFirstJavaScriptBook = new Book("3", "Head First JavaScript", "Wrox");

		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);
		bookService.addBook(headFirstJavaScriptBook);

		books = bookService.books();
	}

	@Test
	public void assertArrayEqualsWithNoMessage() {
		String[] books = bookService.getBookIdsByPublisher("Wrox");
		assertArrayEquals(new String[] {"3", "1"}, books);
	}

	@Test
	public void assertArrayEqualsWithMessage() {
		String[] books = bookService.getBookIdsByPublisher("Wrox");
		assertArrayEquals(new String[] {"3", "1"}, books, "books didn't match");
	}

	@Test
	public void assertArrayEqualsWithMessageSupplier() {
		String[] books = bookService.getBookIdsByPublisher("Wrox");
		assertArrayEquals(new String[] {"3", "1"}, books, () -> "books didn't match");
	}
}
