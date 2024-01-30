package jdbc.day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.vo.CustomerVo;

public class InsertDMLTest {
    public static void main(String[] args) {
        System.out.println("우리 쇼핑몰 [회원가입] 환영합니다.");
        System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");
        
        System.out.print("\t아이디를 입력하세요. __");
        String customId = System.console().readLine();

        System.out.print("\t이름을 입력하세요. __");
        String name = System.console().readLine();

        System.out.print("\t이메일를 입력하세요. __");
        String email = System.console().readLine();

        System.out.print("\t나이를 입력하세요. __");
        int age = Integer.parseInt(System.console().readLine());

        CustomerVo vo = new CustomerVo(customId, name, email, age, null);
        insert(vo);

        // 정리 : tbl_custom 테이블은 회원정보를 저장합니다.
        //     ㄴ개발 프로그램은 '회원가입', '로그인', '회원정보수정', '회원탈퇴' 등의 기능을 테이블을 대상으로 갖게 됩니다.
        //          ㄴ필요한 기능에 처리해야 할 sql 실행 메소드를 DAO(Data Access Object) 클래스에 모두 모아서 만듭니다.
    }

    // 최종적으로 사용될 insert 메소드입니다.
    public static void insert(CustomerVo vo) { // 메소드 실행 인자는 insert 매개변수에 전달될 값
        Connection conn = OracleConnectionUtil.getConnection();
        if (conn != null) {
            System.out.println("데이터베이스 연결 성공!!");
        }

        String sql = "Insert into tbl_custom (custom_id, name, email, age, reg_date) values (?,?,?,?,sysdate)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 " + e.getMessage());
        }

        OracleConnectionUtil.close(conn); 
    }

    // insert sql이 리터럴 값이 아닌 매개변수로 전달받습니다.
    public static void param_data() {
        Connection conn = OracleConnectionUtil.getConnection();
        if (conn != null) {
            System.out.println("데이터베이스 연결 성공!!");
        }

        String sql = "Insert into tbl_custom (custom_id, name, email, age, reg_date) values (?,?,?,?,sysdate)";
        // PreparenetStatement는 매개변수 를 ?로 표기하고 sql을 미리 컴파일합니다.
        //                      매개변수 ?에 대입되는(바인딩) 값은 sql execute 메소드 이전에 설정합니다.

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "sana");
            pstmt.setString(2, "최사나");
            pstmt.setString(3, "sana@naver.com");
            pstmt.setInt(4, 26);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 " + e.getMessage());
        }

        OracleConnectionUtil.close(conn); 
    }

    public static void fixed_date() {
        Connection conn = OracleConnectionUtil.getConnection();
        if (conn != null) {
            System.out.println("데이터베이스 연결 성공!!");
        }

        String sql = "Insert into tbl_custom (custom_id, name, email, age, reg_date) values ('nayeon3','박나연3','na2@gmail.com',27,sysdate)";

        // Auto Close를 위한 try 형식 - pstmt.close() 필요하므로 try -with -resources 사용
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // pstmt.execute(); // sql 실행 메소드
            pstmt.executeUpdate(); // 리턴값 int는 반영된 행의 개수를 리턴
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 " + e.getMessage());
        }

        OracleConnectionUtil.close(conn);
    }
}
