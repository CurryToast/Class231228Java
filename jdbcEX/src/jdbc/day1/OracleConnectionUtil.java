package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionUtil {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    private static final String USER = "c##idev";
    private static final String PASSWORD = "123456";

    // Connection 타입 객체 생성하는 메소드
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 예외 발생");
            System.out.println(e.getMessage());
        }

        return conn;
    }
    // 실행 순서
    // 1) getConnection
    // 2) SQL 실행 : 개발 프로그램에서 가장 많이 실행하는 SQL은 MDL입니다. (select, insert, update, delete)
    // 3) close

    // 인자로 전달된 Connection 객체를 close, sql 실행이 종료되면 close 해야합니다.
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
