package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {
    public static void main(String[] args) {
        // 1) ojdbc11.jar 라이브러리 프로젝트에 추가
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//localhost:1521/XE";
        String user = "c##idev";
        String password = "123456";

        try {
            // 2) 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            // ClassNotFoundException 체크드 익셉션 처리 필요
            // java 6부터 jdbc 4.0 버전이 지원된 후부터 생략 가능 => DriverManager가 알아서 해줌
            Class.forName(driver); // 런타임 시점에 클래스 로드

            // 3) Connection 구현 객체를 생성 - DriverManager는 드라이버 관리하는 유틸리티 클래스
            // SQLException 체크드 익셉션 처리 필요
            conn = DriverManager.getConnection(url, user, password);
            // Connection은 인터페이스 => 이 인터페이스에 대한 구현은 드라이버에 따라 정해짐
            System.out.println("데이터베이스 연결 객체 : " + conn);
            if (conn != null) {
                System.out.println("Connection 객체의 구현 클래스 : " + conn.getClass().getName()); // oracle.jdbc.driver.T4CConnection
                System.out.println("오라클 데이터베이스 연결 성공");
            }
        } catch (Exception e) {
            System.out.println("오라클 데이터베이스 연결 실패 : " + e.getMessage());
        } finally {
            if (conn != null) {
                try { conn.close(); } catch (Exception e) {}
            }
        }
    }
}
