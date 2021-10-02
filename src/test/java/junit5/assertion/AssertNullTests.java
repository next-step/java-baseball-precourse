package junit5.assertion;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import junit5.domain.Book;
import junit5.service.BookService;

public class AssertNullTests {
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
	public void assertNullWithNoMessage() {
		Book actualBook = bookService.getBookById("1");
		assertNull(actualBook);
	}

	@Test
	public void assertNullWithMessage() {
		Book actualBook = bookService.getBookById("1");
		assertNull(actualBook, "Book is not null");
	}

	@Test
	public void assertNullWithMessageSupplier() {
		Book actualBook = bookService.getBookById("1");
		assertNull(actualBook, () -> "Book is not null");
	}
}

