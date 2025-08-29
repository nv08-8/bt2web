package vn.iotstar.dao;

import vn.iotstar.model.User;

/**
 * Servlet implementation class UserDao
 */
public interface UserDao {
    User get(String username);
}