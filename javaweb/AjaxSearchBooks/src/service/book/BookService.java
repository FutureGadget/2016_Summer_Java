package service.book;

import java.sql.Connection;
import java.sql.SQLException;

import common.DBTemplate;
import dao.book.BookDAO;

public class BookService {
	public void removeBookByISBN(String isbn) {
		Connection conn = DBTemplate.getConnection();
		BookDAO dao = new BookDAO();
		boolean result = dao.removeBookByISBN(conn, isbn);
		try {
			if (result) {
				conn.commit();
			} else {
				conn.rollback();
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getBooksByKeyword(String keyword) {
		Connection conn = DBTemplate.getConnection();
		BookDAO dao = new BookDAO();
		String json = dao.getBooksJSONByKeyword(conn, keyword);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}