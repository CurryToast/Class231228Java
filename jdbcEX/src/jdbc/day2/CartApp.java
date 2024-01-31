package jdbc.day2;

import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

public class CartApp {
    public static void main(String[] args) {
        System.out.print("구매할 사용자 간편 로그인");
        System.out.print("\t아이디 입력 >>> ");
        String id = System.console().readLine();

        TblBuyDao dao = new TblBuyDao();
        TblProductDao pdao = new TblProductDao();

        /*
         *  상품 목록을 선택한 카테고리에 대해 보여주기
         *  또는 상품명으로 검색
         *  또는 입력한 아이디로 구매한 구매 내역 보여주기
         */

        boolean run = true;
        while (run) {
            System.out.println("[1] 장바구니 담기  [2] 구매 취소  [3] 구매 수량 변경 [4] 상품 검색 [5] 구매 내역 조회 [6] 종료");
            try {
                int select = Integer.parseInt(System.console().readLine());
                switch (select) {
                    case 1:
                        addItems(dao, id);
                        break;
                    case 2:
                        selectBuyList(dao, id);
                        removeItems(dao, id);
                        break;
                    case 3:
                        selectBuyList(dao, id);
                        updateQuantity(dao, id);
                        break;
                    case 4:
                        searchProduct(pdao);
                        break;
                    case 5:
                        selectBuyList(dao, id);
                        break;
                    case 6:
                        System.out.println("프로그램 종료");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("없는 메뉴입니다.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void addItems(TblBuyDao dao, String id) {
        System.out.print("구매할 상품 코드 입력 >> ");
        String pcode = System.console().readLine();
        System.out.print("구매할 수량 입력 >> ");
        int quantity = Integer.parseInt(System.console().readLine());

        BuyVo vo = new BuyVo(id, pcode, quantity);
        if (dao.add(vo) == 1) {
            System.out.println("상품을 담았습니다.");
        } else {
            System.out.println("없는 상품코드 또는 고객 아이디입니다.");
        }
    }

    public static void removeItems(TblBuyDao dao, String customId) {
        System.out.print("\n삭제할 항목의 buy_idx 입력 >> ");
        int idx = Integer.parseInt(System.console().readLine());
        if (dao.remove(idx) == 1) {
            System.out.println("정상적으로 취소되었습니다.");
        } else {
            System.out.println("없는 구매번호 입니다.");
        }
    }

    public static void updateQuantity(TblBuyDao dao, String customId) {
        System.out.print("\n구매수량을 변경할 항목의 buy_idx 입력 >> ");
        int idx = Integer.parseInt(System.console().readLine());
        System.out.print("변경할 구매수량 입력 >> ");
        int quantity = Integer.parseInt(System.console().readLine());
        if (dao.update(idx, quantity) == 1) {
            System.out.println("정상적으로 수정되었습니다.");
        } else {
            System.out.println("없는 구매번호 입니다.");
        }
    }

    public static void searchProduct(TblProductDao dao) {
        System.out.print("검색 메뉴 입력 (1. 카테고리로 검색, 2. 상품명으로 검색) >>  ");
        try {
            int menu = Integer.parseInt(System.console().readLine());

            switch (menu) {
                case 1:
                    searchProductByCategory(dao);
                    break;
                case 2:
                    searchProductByPname(dao);
                    break;
                default:
                    System.out.println("없는 메뉴입니다.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public static void searchProductByCategory(TblProductDao dao) {
        System.out.print("검색할 카테고리 입력 >> ");
        String category = System.console().readLine();

        List<ProductVo> list = dao.selectByCategory(category);
        for (ProductVo vo : list) {
            System.out.println(vo);
        }
    }

    public static void searchProductByPname(TblProductDao dao) {
        System.out.print("검색할 상품명 입력 >> ");
        String pname = System.console().readLine();

        List<ProductVo> list = dao.selectByPname(pname);
        for (ProductVo vo : list) {
            System.out.println(vo);
        }
    }

    public static void selectBuyList(TblBuyDao dao, String id) {
        System.out.println("구매 내역 조회");
        List<CustomerBuyVo> list = dao.selectCustomerBuyList(id);
        for (CustomerBuyVo vo : list) {
            System.out.println(vo);
        }
    }
}
