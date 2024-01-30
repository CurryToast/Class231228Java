package jdbc.day2;

import java.util.ArrayList;
import java.util.List;

import project.dao.TblCustomerDao;
import project.vo.CustomerVo;

public class CustomerMain {
    public static void main(String[] args) {
        System.out.println("[고객관리시스템] 고객을 조회합니다.");
        System.out.print("ID 입력 (all: 고객 전부 조회) >> ");
        String customerId = System.console().readLine();

        System.out.println("\n~~~~~~~~~~~~~조회 결과~~~~~~~~~~~~~~~");

        TblCustomerDao dao = new TblCustomerDao();

        if (customerId.equals("all")) {
            List<CustomerVo> list = new ArrayList<CustomerVo>();
            if (list.size() > 0) {
                System.out.println(list);
            } else {
                System.out.println("고객이 없습니다!");
            }
        } else {
            CustomerVo vo = dao.getCustomer(customerId);
            if (vo == null) {
                System.out.println("고객이 없습니다!");
            } else {
                System.out.println(vo);
            }
        }
    }
}
