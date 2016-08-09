package dao.user;

import common.DBTemplate;
import entity.user.UserEntity;
import java.sql.*;

public class UserDAO {
	// DBCP 를 사용할 것.
	// 1. context.xml를 WebContent 아래의 META-INF에 위치시킨다.
	// 2. username, password, url 수정
	// 3. DBTemplate.java 파일을 common package에 위치시킨다.
	public boolean select(UserEntity entity) {
		boolean result = false;
		Connection conn = DBTemplate.getConnection();
		String sql = "SELECT uid,upw,uname,uemail FROM user_tbl WHERE uid=? and upw = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 결과가 존재하면 rs.next() 리턴값이 true이다.
				result = true;
			} else {
				result = false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
