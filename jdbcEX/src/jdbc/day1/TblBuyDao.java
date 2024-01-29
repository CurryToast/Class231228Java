package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<BuyVo> selectedBuyListByCustomId(String customId) {
        List<BuyVo> voList = new ArrayList<BuyVo>();
        String sql = "SELECT * FROM TBL_BUY WHERE CUSTOMID = ?";
        
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, customId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                voList.add(new BuyVo(rs.getInt("BUY_IDX"), rs.getString("CUSTOMID"), rs.getString("PCODE"), rs.getInt("QUANTITY"), rs.getDate("BUY_DATE")));
            }
        } catch (SQLException e) {
            System.out.println("select 쿼리 실패 " + e.getMessage());
        }

        return voList;
    }


    public void printBuyVoList(List<BuyVo> list) {
        for (BuyVo vo : list) {
            System.out.println(vo);
        }
    }
}
