package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBTemplate;
import entity.User;

public class UserDAO {
	public String getPassword(User user) {
		Connection conn = DBTemplate.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement("SELECT upw FROM user_tbl WHERE uid = ?");
			pstmt.setString(1, user.getUid());
			result = pstmt.executeQuery();
			if (result.next()) {
				return result.getString("upw");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTemplate.close(pstmt);
			DBTemplate.close(result);
			DBTemplate.close(conn);
		}
		return null;
	}
}
