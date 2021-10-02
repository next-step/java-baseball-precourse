package junit5.assertion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit5.domain.Book;
import junit5.service.BookService;

@Disabled
public class AssertTimeoutTests {

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
	public void assertTimeoutWithMessage() {

		IntStream.rangeClosed(0, 9998)
			.forEach(i -> bookService.addBook(new Book(String.valueOf(i), "Head First", "Wrox")));

		List<String> actualList = new ArrayList<>();

		assertTimeout(Duration.ofMillis(1), () -> {
			actualList.addAll(bookService.getBookTitleByPublisher("Wrox"));
		}, "Performance issues with getBookTitleByPublisher() method");

		assertEquals(10000, actualList.size());

	}
}
