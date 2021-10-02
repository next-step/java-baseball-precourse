package junit5.assertion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit5.domain.Book;
import junit5.service.BookService;

@Disabled
public class AsserTrueTests {

	private BookService bookService;
	private Book book;
	List<Book> books;

	@BeforeEach
	public void init() {
		bookService = new BookService();
		book = new Book("1", "Head First Java", "Wrox");
		//		bookService.addBook(book);
		books = bookService.books();
	}

	@Test
	public void assertTrueWithNoMessage() {
		assertTrue(books.isEmpty());
	}

	@Test
	public void assertTrueWithMessage() {
		assertTrue(books.isEmpty(), "List of books is not empty");
	}

	@Test
	public void assertTrueWithMessageSupplier() {
		assertTrue(books.isEmpty(), () -> "List of books is not empty");
	}

	@Test
	public void assertTrueBooleanSupplierNoWithMessage() {
		assertTrue(() -> books.isEmpty());
	}

	@Test
	public void assertTrueBooleanSupplierWithMessage() {
		assertTrue(() -> books.isEmpty(), "List of books is not empty");
	}

	@Test
	public void assertTrueBooleanSupplierAndMessageSupplier() {
		assertTrue(() -> books.isEmpty(), () -> "List of books is not empty");
	}

}
