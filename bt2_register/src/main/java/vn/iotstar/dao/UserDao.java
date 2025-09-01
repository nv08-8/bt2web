package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.*;

public interface UserDao {
	void insert(User user);
	
	void update(User user);
	
	void updatestatus(User user);
	
	List<User> findAll();
	
	User findById(int id);
	
	User findByUserName(String username);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

}
