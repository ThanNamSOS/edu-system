package com.edusys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XJdbc {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=SOF2041";
    static String user = "sa";
    static String pass = "513223";
//
//    static {
//        try {
//            Class.forName(driver);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static Connection getConnection(){
        Connection con = null;
        try {
            DriverManager.deregisterDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt;

        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql); //PROC
        } else {
            stmt = conn.prepareStatement(sql); //SQL
        }

        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = XJdbc.getStmt(sql, args);
        return stmt.executeQuery();
    }

//    public static Object value(String sql, Object... args) {
//        try {
//            ResultSet rs = XJdbc.query(sql, args);
//            if (rs.next()) {
//                return rs.getObject(0);
//            }
//            rs.getStatement().getConnection().close();
//            return null;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
