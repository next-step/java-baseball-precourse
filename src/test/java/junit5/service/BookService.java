package junit5.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.InstanceNotFoundException;

import junit5.BookNotFoundException;
import junit5.domain.Book;

public class BookService {

	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> books() {
		return Collections.unmodifiableList(books);
	}

	public Book getBookById(String bookId) {
		
		return books
				.stream()
				.filter(book -> book.getBookId().equals(bookId))
				.findFirst()
				.orElseThrow(() -> new BookNotFoundException("Book Not Found"));

//		for (Book book : books) {
//			if (book.getBookId().equals(bookId)) {
//				return book;
//			}
//		}
//		return null;
	}

	public String[] getBookIdsByPublisher(String publisher) {
		return books
				.stream()
				.filter(book -> book.getPublisher().equals(publisher))
				.map(book-> book.getBookId())
				.toArray(String[]::new);
	}
	
	
	public List<String> getBookTitleByPublisher(String publisher) {
		return books
				.stream()
				.filter(book -> book.getPublisher().equals(publisher))
				.map(book->book.getTitle())
				.collect(Collectors.toList());
	}
	
	
}
