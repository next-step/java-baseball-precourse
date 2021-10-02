package junit5.assertion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit5.domain.Book;
import junit5.service.BookService;

public class AssertIterableEqualsTests {

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
	public void assertIterableEqualsWithNoMessage() {
		List<String> books = bookService.getBookTitleByPublisher("Wrox");
		assertIterableEquals(Arrays.asList("Head First JavaScript", "Head First Java"), books);
	}

	@Test
	public void assertIterableEqualsWithMessage() {
		List<String> books = bookService.getBookTitleByPublisher("Wrox");
		assertIterableEquals(Arrays.asList("Head First JavaScript", "Head First Java"), books, "Books didn't match");
	}

	@Test
	public void assertIterableEqualsWithMessageSupplier() {
		List<String> books = bookService.getBookTitleByPublisher("Wrox");
		assertIterableEquals(Arrays.asList("Head First JavaScript", "Head First Java"), books, () -> "Books didn't match");
	}

}
