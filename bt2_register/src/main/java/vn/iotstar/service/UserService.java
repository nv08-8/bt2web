package vn.iotstar.service;

import vn.iotstar.User;

public interface UserService {
	void insert(User user);

	boolean register(String username, String password, String email, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
    User login(String username, String password);
    
    User FindByUserName(String username);
} 