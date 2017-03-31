package pkgException;

import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class BookException extends Exception {

	private String BookID;
	private Book b;
	private Catalog cat;
	public BookException(String bookID, Catalog cat) {
		super();
		BookID = bookID;
		this.cat = cat;
	}
	public BookException(Book b, Catalog cat) {
		super();
		this.b = b;
		this.cat = cat;
	}
	public String getBookID() {
		return BookID;
	}
	public Book getB() {
		return b;
	}
	public Catalog getCat() {
		return cat;
	}
	
	
}
