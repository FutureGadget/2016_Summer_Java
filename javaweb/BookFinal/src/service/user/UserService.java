package service.user;

import dao.user.UserDAO;
import entity.user.UserEntity;

public class UserService {
	public boolean login(UserEntity entity) {
		boolean result = false;
		
		// �α��ο� ���� ����ó��.
		// Database ó���� ����
		UserDAO dao = new UserDAO();
		result = dao.select(entity);
		
		return result;
	}
}