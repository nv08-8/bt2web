package vn.iotstar.dao;

import vn.iotstar.model.User;
import vn.iotstar.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String FIND_BY_USERNAME_SQL =
        "SELECT id, email, username, fullname, [password], avatar, roleid, phone, createdDate " +
        "FROM [User] WHERE username = ?";

    @Override
    public User get(String username) {
        System.out.println("=== [DAO] get() CALLED, username=" + username + " ===");

        try (Connection conn = new DBConnection().getConnection()) {

            // 1) Kiểm tra đang kết nối đúng DB + tổng số user (debug)
            try (var st = conn.createStatement();
                 var rsInfo = st.executeQuery("SELECT DB_NAME() AS db, COUNT(*) AS total FROM [User]")) {
                if (rsInfo.next()) {
                    System.out.println("[DAO] Connected DB = " + rsInfo.getString("db")
                            + ", total users = " + rsInfo.getInt("total"));
                }
            }

            // 2) Query lấy user theo username
            try (PreparedStatement ps = conn.prepareStatement(FIND_BY_USERNAME_SQL)) {
                ps.setString(1, username == null ? null : username.trim());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // In mật khẩu DB để so sánh lúc debug (xong nhớ bỏ)
                        System.out.println("[DAO] DB password = " + rs.getString("password"));

                        User u = new User();
                        u.setId(rs.getInt("id"));
                        u.setEmail(rs.getString("email"));
                        u.setUserName(rs.getString("username"));
                        u.setFullName(rs.getString("fullname"));
                        u.setPassWord(rs.getString("password"));
                        u.setAvatar(rs.getString("avatar"));
                        u.setRoleid(rs.getInt("roleid"));          // dùng getInt cho chuẩn
                        u.setPhone(rs.getString("phone"));
                        u.setCreatedDate(rs.getDate("createdDate"));
                        System.out.println("[DAO] RETURN user id=" + u.getId());
                        return u;
                    } else {
                        System.out.println("[DAO] NO ROW for username=" + username);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("[DAO] SQLException khi lấy user:");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("[DAO] Lỗi khác khi lấy user:");
            e.printStackTrace();
        }

        System.out.println("[DAO] RETURN null");
        return null;
    }
}
