package jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnectionUtil;
import project.vo.CustomerVo;

public class SelectDMLTest {
    public static void main(String[] args) {
        List<CustomerVo> result = selectAll_4();
        System.out.println(result);
    }

    public static List<CustomerVo> selectAll_4() {
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * from tbl_custom";

        List<CustomerVo> list = new ArrayList<CustomerVo>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) { // 읽어올 다음 레코드가 있으면 true
                list.add(new CustomerVo(
                    rs.getString("custom_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age"),
                    rs.getDate("reg_date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 오류 : " + e.getMessage());
        }

        return list;
    }

    public static void selectAll_3() {
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * from tbl_custom";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            CustomerVo vo;

            while (rs.next()) { // 읽어올 다음 레코드가 있으면 true
                vo = new CustomerVo(rs.getString("custom_id"), rs.getString("name"), rs.getString("email"),  rs.getInt("age"), rs.getDate("reg_date"));
                System.out.println(vo);
            }
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 오류 : " + e.getMessage());
        }
    }

    public static void selectAll_2() {
        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "SELECT * from tbl_custom";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) { // 읽어올 다음 레코드가 있으면 true
                System.out.println("row : " + rs.getRow());
                System.out.println(rs.getString("custom_id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("reg_date"));
                System.out.println(rs.getTimestamp("reg_date"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 오류 : " + e.getMessage());
        }
    }

    public static void selectAll_1() {
        Connection connection = OracleConnectionUtil.getConnection();

        String sql = "SELECT * from tbl_custom";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery(); // 쿼리 실행한 결과 행 집합을 처리하는 인터페이스 : ResultSet
            rs.next(); // 결과 행 집합의 첫번째 행을 접근하기 위해 꼭 한번은 실행해야 할 메소드
                       // next 메소드는 rs 객체의 다음 행에 접근할 수 있게 포인터 이동합니다.
            System.out.println(rs.getString(1)); // 1번 컬럼
            System.out.println(rs.getString(2)); // 2번 컬럼
            System.out.println(rs.getString(3)); // 3번 컬럼
            System.out.println(rs.getInt(4)); // 4번 컬럼
            System.out.println(rs.getDate(5)); // 5번 컬럼. 리턴 타입 : java.sql.Date
            System.out.println(rs.getTimestamp(5)); // 5번 컬럼. 리턴 타입 : java.sql.Timestamp
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 오류 : " + e.getMessage());
        }
    }
}
