package vn.iotstar.service;

import vn.iotstar.dao.*;
import vn.iotstar.User;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    
	@Override
	public User login(String username, String password) {
		User user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
    	if (userDao.checkExistEmail(email)) {
            return false;
        }
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        
        User u = new User();
        u.setUserName(username);
        u.setPassWord(password);
        u.setEmail(email);
        u.setFullName(fullname);
        u.setPhone(phone);
        u.setImages(null);
        u.setRoleid(3);
        u.setCreatedDate(date);

        userDao.insert(u);        
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
    
	
	@Override
	public User FindByUserName(String username) {
		return userDao.findByUserName(username);
	}
}
