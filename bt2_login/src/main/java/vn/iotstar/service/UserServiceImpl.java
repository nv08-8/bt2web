package vn.iotstar.service;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.UserDaoImpl;
import vn.iotstar.model.User;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        System.out.println("[SVC] login() username=" + username + ", password=" + password);
        User u = userDao.get(username); // <-- sẽ in [DAO]
        if (u != null) System.out.println("[SVC] DB password=" + u.getPassWord());
        boolean ok = (u != null && password != null && password.equals(u.getPassWord()));
        System.out.println("[SVC] login result = " + ok);
        return ok ? u : null;
    }

    @Override
    public User get(String username) {
        System.out.println("[SVC] get() -> DAO");
        return userDao.get(username);
    }
}
