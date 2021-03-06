package dao.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBTemplate;
import entity.book.BookEntity;

public class BookDAO {
	public ArrayList<BookEntity> queryBookByName(String bookName) {
		ArrayList<BookEntity> list = new ArrayList<>();
		Connection conn = DBTemplate.getConnection();
		try {
			String sql = "SELECT bisbn, btitle, bauthor, bprice, bimgurl FROM books WHERE btitle LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bookName+"%"); // % = cmd에서 *와 같음 (% matches any number of characters, even zero characters.)
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BookEntity(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"),
						rs.getString("bprice"), rs.getString("bimgurl")));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<BookEntity> queryBookByISBNs(String[] isbns) {
		ArrayList<BookEntity> list = new ArrayList<>();
		Connection conn = DBTemplate.getConnection();
		String sql = "SELECT bisbn, btitle, bauthor, bprice, bimgurl FROM books WHERE bisbn LIKE ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (String s : isbns) {
				pstmt.setString(1, s);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) list.add(new BookEntity(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"),
						rs.getString("bprice"), rs.getString("bimgurl")));
				rs.close();
			}
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
