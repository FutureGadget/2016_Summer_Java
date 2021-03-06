package service.book;

import java.util.ArrayList;

import dao.book.BookDAO;
import entity.book.BookEntity;

public class BookService {
	public ArrayList<BookEntity> searchByKeyword(String bookName) {
		BookDAO dao = new BookDAO();
		return dao.queryBookByName(bookName);
	}
	public ArrayList<BookEntity> getBookListByISBNs(String[] isbns) {
		BookDAO dao = new BookDAO();
		return dao.queryBookByISBNs(isbns);
	}
}
