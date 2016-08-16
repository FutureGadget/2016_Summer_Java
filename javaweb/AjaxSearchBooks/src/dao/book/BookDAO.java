package dao.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BookDAO {
	public boolean removeBookByISBN(Connection conn, String isbn) {
		boolean result = false;
		String sql = "delete FROM books WHERE bisbn = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				result = true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public String getBooksJSONByKeyword(Connection conn, String keyword) {
		String sql = "SELECT bisbn, btitle, bprice, bauthor, bimgurl FROM books WHERE btitle LIKE ?";
		JSONArray array = new JSONArray();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("bisbn", rs.getString("bisbn"));
				obj.put("btitle", rs.getString("btitle"));
				obj.put("bauthor", rs.getString("bauthor"));
				obj.put("bprice", rs.getString("bprice"));
				obj.put("bimgurl", rs.getString("bimgurl"));
				array.add(obj);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array.toJSONString();
	}
}