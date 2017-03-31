package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import pkgException.BookException;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book getBook(String bookID) throws BookException
	{
		for (Book b: this.getBooks())
		{
			if (b.getId().equals(bookID)) 
			{
				return b;
			}
		}
		
		throw new BookException(bookID, this);
	}
	
	public void addBook(Book addBook) throws BookException
	{
		for (Book b: this.getBooks())
		{
			if (b.getId().equals(addBook.getId())) 
			{
				throw new BookException(addBook, this);
			}
		}		
		this.getBooks().add(addBook);
	}
	


	
	
	
	
}
