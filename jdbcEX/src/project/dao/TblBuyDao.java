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

    // executeUpdate 메소드는 insert, update, delete가 정상 실행되면(반영된 행이 있으면) 1을 리턴
    //                              ㄴ update, delete는 조건에 맞는 행이 없으면 0을 리턴
    public int add(BuyVo vo) {
        int result = 0;
        String sql = "INSERT INTO TBL_BUY (BUY_IDX , CUSTOMID, PCODE, QUANTITY, BUY_DATE) \r\n" + //
                "VALUES (buy_pk_seq.nextval, ?, ?, ?, SYSDATE)";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getCustomid());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("장바구니 추가 실패 " + e.getMessage());
        }

        return result;
    }

    public int remove(int buyIdx) {
        int result = 0;
        String sql = "DELETE FROM TBL_BUY tb WHERE buy_idx = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, buyIdx);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // buy_idx가 없는 값이면 오류는 아니고, delete 반영한 행의 개수가 0이 됩니다.
            System.out.println("구매취소 실패 " + e.getMessage());
        }

        return result;
    }

    public int update(int buyIdx, int quantity) {
        int result = 0;
        String sql = "UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, buyIdx);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // buy_idx가 없는 값이면 오류는 아니고, update 반영한 행의 개수가 0이 됩니다.
            System.out.println("구매수량 변경 실패 " + e.getMessage());
        }

        return result;
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
            System.out.println("내 구매정보 조회 실패 : " + e.getMessage());
        }

        return list;
    }
}
