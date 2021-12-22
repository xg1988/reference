package com.refer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnect {
	// �����ͺ��̽� ���ӿ� �ʿ��� ���� ����
    private static final String db_hostname = "jobsjo88.cafe24.com";
    private static final int db_portnumber = 3306;
    private static final String db_database = "jobsjo88";
    private static final String db_charset = "utf8";
    private static final String db_username = "jobsjo88";
    private static final String db_password = "l2p7w4!!";

    // ���� ó���� ���� ��ü ����
    private Connection conn = null;

    // === �̱��� ��ü ===
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

    // === �̱��� ��ü ===

    public Connection open() {
        if (conn == null) {
            /** �����ͺ��̽� ���� ó�� */
            // �����ͺ��̽� ���� ������ URL�� �����
            String urlFormat = "jdbc:mysql://%s:%d/%s?&charsetEncoding=%s";
            String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

            // MySQL JDBC�� ����̹� Ŭ������ �ε��ؼ� DriverManager Ŭ������ ����Ѵ�.
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
            /** �����ͺ��̽� ���� ���� ó�� */

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
