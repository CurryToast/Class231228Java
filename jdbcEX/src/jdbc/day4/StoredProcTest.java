package jdbc.day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.day1.OracleConnectionUtil;

public class StoredProcTest {
    public static void main(String[] args) {
        // exec_max_customer();
        money_of_day();   
    }

    private static void money_of_day() {
        System.out.println("고객ID와 날짜를 입력하면 총 구매 금액을 조회합니다.");
        System.out.print("고객 ID 입력 >> ");
        String customid = System.console().readLine();
        System.out.print("구매날짜 입력 >> ");
        String buydate = System.console().readLine(); // 입력 형식 : yyyy-mm-dd

        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{ call money_of_day(?,?,?) }";

        try (CallableStatement cstmt = connection.prepareCall(sql)) {
            // 프로시저 IN 매개변수값 전달
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            // 프로시저 OUT 매개변수 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();

            System.out.println(String.format("%s 고객님이 %s에 구매한 총 구매금액 : %,8d", customid, buydate, cstmt.getInt(3)));
        } catch (SQLException e) {
            System.out.println("money of day 프로시저 실행 오류 : " + e.getMessage());
        }
    }

    private static void exec_max_customer() {
        Connection connection = OracleConnectionUtil.getConnection();
        // 프로시저 SQL 형식 "{ call 프로시저이름(?,?,...) }" 매개변수는 정의된 개수만큼 ? 나열
        String sql = "{ call max_custom(?,?) }";

        try (
            CallableStatement cstmt = connection.prepareCall(sql) // 프로시저 실행 및 관리 인터페이스
        ) {
            // 프로시저 실행 결과 OUT 파라미터 1번 인덱스의 오라클 데이터 타입 지정하기 - 고객 이름
            cstmt.registerOutParameter(1, Types.VARCHAR);

            // 프로시저 실행 결과 OUT 파라미터 2번 인덱스의 오라클 데이터 타입 지정하기 - 고객 나이
            cstmt.registerOutParameter(2, Types.NUMERIC);

            cstmt.executeUpdate();

            // 프로시저 실행 결과 OUT 파라미터 값은 cstmt 객체에 저장됩니다.
            // 쇼핑몰 관리자(일반 사용자)가 원하는 정보
            System.out.println("구매 수량이 가장 많은 고객 정보 조회한 결과입니다.");

            // 인덱스 1번 OUT 실행 결과값 가져오기
            System.out.println("고객 이름 : " + cstmt.getString(1));
            // 인덱스 2번 OUT 실행 결과값 가져오기
            System.out.println("고객 나이 : " + cstmt.getInt(2));
        } catch (SQLException e) {
            System.out.println("max custom 프로시저 실행 오류 : " + e.getMessage());
        }
    }
}
