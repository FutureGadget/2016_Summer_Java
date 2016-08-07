package service;

import dao.UserDAO;
import entity.User;

public class UserService {
	public boolean authenticate(User user) {
		UserDAO dao = new UserDAO();
		String passwd = dao.getPassword(user);
		if (passwd != null && user.getUpw().equals(passwd)) {
			return true;
		}
		return false;
	}
}
