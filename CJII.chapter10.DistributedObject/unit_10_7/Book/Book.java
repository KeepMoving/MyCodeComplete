package unit_10_7.Book;

import unit_10_6.Product.Product;

public class Book extends Product
{
	public Book(String title,String isbn,double price)
	{
		super(title,price);
		this.isbn = isbn;
	}
	
	public String getDescription()
	{
		return super.getDescription() + " " + isbn;
	}
	
	private String isbn;
}
