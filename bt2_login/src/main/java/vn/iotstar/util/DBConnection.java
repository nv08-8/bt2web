package vn.iotstar.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL =
        "jdbc:sqlserver://localhost;databaseName=NHU_LoginDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "Tfboyslove088@";

    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
