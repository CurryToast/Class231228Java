package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TblCustomerDao {
    private static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 회원 가입
    public void join(CustomerVo vo) {
        String sql = "Insert into tbl_custom (custom_id, name, email, age, reg_date) values (?,?,?,?,sysdate)";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) { // Auto Close
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Join 실행 오류 " + e.getMessage());
        }
    }

    // 회원 정보 수정
    public void modify(CustomerVo vo) {
        String sql = "UPDATE TBL_CUSTOM SET EMAIL = ?, age = ? WHERE CUSTOM_ID = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Modify 실행 오류 " + e.getMessage());
        }
    }

    // 회원 탈퇴
    public void delete(String id) {
        String sql = "DELETE FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Delete 실행 오류 " + e.getMessage());
        }
    }

    // 회원 정보 조회
    public CustomerVo getCustomer(String customerId) {
        String sql = "SELECT * FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";
        List<CustomerVo> vo = new ArrayList<CustomerVo>();

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, customerId);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                vo.add(new CustomerVo(result.getString("CUSTOM_ID"), result.getString("NAME"), result.getString("EMAIL"), result.getInt("AGE"), result.getDate("REG_DATE")));
            }
        } catch (Exception e) {
        }

        if (vo.size() > 0) {
            return vo.get(0);
        }

        return null;
    }

    // 관리자를 위한 기능 : 모든 회원정보 조회
    public List<CustomerVo> allCustomer() {
        String sql = "SELECT * FROM TBL_CUSTOM";
        List<CustomerVo> vo = new ArrayList<CustomerVo>();

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            ResultSet result = pstmt.executeQuery(sql);
            while (result.next()) {
                vo.add(new CustomerVo(result.getString("CUSTOM_ID"), result.getString("NAME"), result.getString("EMAIL"), result.getInt("AGE"), result.getDate("REG_DATE")));
            }
        } catch (Exception e) {
        }

        return vo;
    }
}
