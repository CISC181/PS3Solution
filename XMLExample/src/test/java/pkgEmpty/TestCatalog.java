package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pkgException.BookException;
import pkgLibrary.Book;
import pkgLibrary.Catalog;
import pkgMain.XMLReader;

public class TestCatalog {

	private Catalog cat;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cat = XMLReader.ReadXMLFile();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestReadCatalog() {
		
		System.out.println(cat.getBooks().size());
		
		assertTrue(cat.getBooks().size() > 0);
	}
	
	@Test
	public void TestGetBook()
	{
		try {
			Book b1 = cat.getBook("bk102");			
			assertNotNull(b1);
			
		} catch (BookException e) {
			fail("getBook() failed");
		}
		
	}
	
	@Test (expected=pkgException.BookException.class)
	public void TestBadGetBook() throws BookException
	{
		Book b999 = cat.getBook("bk999999");		
	}

	@Test
	public void TestSetCost()
	{
		for (Book b: cat.getBooks())
		{
			b.setCost(b.getPrice() * 0.80);
		}
		
		XMLReader.WriteXMLFile(cat);
	}
}
