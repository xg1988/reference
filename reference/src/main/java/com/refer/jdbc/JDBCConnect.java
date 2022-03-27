package com.refer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnect {
	// 데이터베이스 접속에 필요한 정보 정의
    private static final String db_hostname = "jobsjo88.cafe24.com";
    private static final int db_portnumber = 3306;
    private static final String db_database = "jobsjo88";
    private static final String db_charset = "utf8";
    private static final String db_username = "jobsjo88";
    private static final String db_password = "l2p7w4!!";

    // 접속 처리를 위한 객체 선언
    private Connection conn = null;

    // === 싱글톤 객체 ===
    private static JDBCConnect current = null;

    public static JDBCConnect getInstance() {
        if (current == null) {
            current = new JDBCConnect();
        }
        return current;
    }

    public void freeInstace() {
        current = null;
    }

    public JDBCConnect() {
    }

    // === 싱글톤 객체 ===

    public Connection open() {
        if (conn == null) {
            /** 데이터베이스 접속 처리 */
            // 데이터베이스 명을 포함한 URL을 만든다
            String urlFormat = "jdbc:mysql://%s:%d/%s?&charsetEncoding=%s";
            String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

            // MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager 클래스에 등록한다.
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conn = DriverManager.getConnection(url, db_username, db_password);
                System.out.println("=== DATABASE Connect Success ===");
            } catch (ClassNotFoundException e) {
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                System.out.println("=== DATABASE Connect Fail ===");
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    public void close() {
        if (conn != null) {
            /** 데이터베이스 접속 해제 처리 */

            try {
                conn.close();
                System.out.println("=== DATABASE Disconnect Success ===");
            } catch (SQLException e) {
                System.out.println("=== DATABASE Disconnect Fail ===");
                System.out.println(e.getMessage());
            }
            conn = null;
        }
    }

}
