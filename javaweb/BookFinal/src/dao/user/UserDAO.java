package dao.user;

import common.DBTemplate;
import entity.user.UserEntity;
import java.sql.*;

public class UserDAO {
	// DBCP �� ����� ��.
	// 1. context.xml�� WebContent �Ʒ��� META-INF�� ��ġ��Ų��.
	// 2. username, password, url ����
	// 3. DBTemplate.java ������ common package�� ��ġ��Ų��.
	public boolean select(UserEntity entity) {
		boolean result = false;
		Connection conn = DBTemplate.getConnection();
		String sql = "SELECT uid,upw,uname,uemail FROM user_tbl WHERE uid=? and upw = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // ����� �����ϸ� rs.next() ���ϰ��� true�̴�.
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
