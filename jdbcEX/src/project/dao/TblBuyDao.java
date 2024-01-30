package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    private static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void add(BuyVo vo) {
        String sql = "INSERT INTO TBL_BUY (BUY_IDX , CUSTOMID, PCODE, QUANTITY) VALUES (buy_pk_seq.nextval, ?, ?, ?)";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getCustomid());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert 쿼리 실패 " + e.getMessage());
        }
    }

    public void remove(int buyIdx) {
        String sql = "DELETE FROM TBL_BUY tb WHERE buy_idx = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, buyIdx);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete 쿼리 실패 " + e.getMessage());
        }
    }

    public void update(int buyIdx, int quantity) {
        String sql = "UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, buyIdx);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("UPDATE 쿼리 실패 " + e.getMessage());
        }
    }

    // MyPage 기능 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String customId) {
        List<CustomerBuyVo> list = new ArrayList<CustomerBuyVo>();

        String sql = "SELECT BUY_IDX, tp.PCODE, PNAME, PRICE, QUANTITY, BUY_DATE \r\n" + //
                "FROM TBL_BUY tb \r\n" + //
                "JOIN TBL_PRODUCT tp \r\n" + //
                "ON tb.PCODE = tp.PCODE \r\n" + //
                "WHERE tb.CUSTOMID = ? \r\n" + //
                "ORDER BY BUY_DATE DESC";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, customId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CustomerBuyVo(
                    rs.getInt("buy_idx"),
                    rs.getString("pcode"),
                    rs.getString("pname"),
                    rs.getInt("price"),
                    rs.getInt("quantity"),
                    rs.getTimestamp("buy_date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 실패 : " + e.getMessage());
        }

        return list;
    }
}
