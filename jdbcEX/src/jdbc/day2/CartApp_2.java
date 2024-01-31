package jdbc.day2;

import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

// static이 많아지면 상속특징을 사용할 수 없습니다. 멀티 스레드 환경에도 적합하지 않습니다.
//      ㄴ 여기서는 테스트를 위해 static 사용 중입니다.
public class CartApp_2 {
    public static void main(String[] args) {
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerId = System.console().readLine();
        System.out.println(customerId + "님 환영합니다.\n");

        showMyPage(customerId);
    }


    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회     [P] 상품명 검색  [M] 나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }

    public static void showMyPage(String customerId) {
        TblBuyDao buyDao = new TblBuyDao();
        TblProductDao proDao = new TblProductDao();

        //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
        //또는 상품명으로 검색 (구매할 상품 조회)
        //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)

        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");
            String select = System.console().readLine();
            switch (select) {
                case "C", "c":
                    showProductListByCategory(proDao, customerId);
                    break;
                case "P", "p":
                    showProductListByPname(proDao);
                    break;
                case "M", "m": // 나의 구매내역
                    showMyBuyList(buyDao, customerId);
                    break;
                case "B", "b":
                    showProductList(proDao);
                    buyProduct(buyDao, customerId);
                    break;
                case "D", "d":
                    showMyBuyList(buyDao, customerId);
                    cancelBuy(buyDao, customerId);
                    break;
                case "Q", "q":
                    showMyBuyList(buyDao, customerId);
                    changeMyBuyQuantity(buyDao);
                    break;
                case "X", "x":
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void showProductList(TblProductDao proDao) {
        List<ProductVo> list = proDao.selectAllProduct();
        for (ProductVo productVo : list) {
            System.out.println(productVo);
        }
    }

    public static void showProductListByPname(TblProductDao proDao) {
        System.out.print("상품명 검색 >> ");
        String pname = System.console().readLine();
        List<ProductVo> list = proDao.selectByPname(pname);
        for (ProductVo productVo : list) {
            System.out.println(productVo);
        }
    }

    public static void showProductListByCategory(TblProductDao proDao, String customerId) {
        System.out.println("카테고리 : A1-과일, A2-수입과일, B1-인스턴스, B2-선물세트, C1-과자류");
        System.out.print("카테고리 입력 >> ");
        String category = System.console().readLine();
        List<ProductVo> pv = proDao.selectByCategory(category);
        for (ProductVo productVo : pv) {
            System.out.println(productVo);
        }
    }

    public static void showMyBuyList(TblBuyDao buyDao, String customerId) {
        System.out.println("장바구니 목록");
        List<CustomerBuyVo> result = buyDao.selectCustomerBuyList(customerId);
        for (CustomerBuyVo customerBuyVo : result) {
            System.out.println(customerBuyVo);
        }
    }

    public static void buyProduct(TblBuyDao buyDao, String customerId) {
        System.out.print("구매할 상품 코드 입력 >>> ");
        String pcode = System.console().readLine();
        System.out.print("구매할 수량 입력 >> ");
        int quantity = Integer.parseInt(System.console().readLine());

        BuyVo vo = new BuyVo(customerId, pcode, quantity);
        if (buyDao.add(vo) == 1) {
            System.out.println("상품을 담았습니다.");
        } else {
            System.out.println("상품코드 또는 고객아이디 오류입니다.");
        }
    }

    public static void cancelBuy(TblBuyDao buyDao, String customerId) {
        System.out.print("\n삭제할 항목의 buy_idx 입력 >> ");
        int idx = Integer.parseInt(System.console().readLine());
        if (buyDao.remove(idx) == 1) {
            System.out.println("정상적으로 취소되었습니다.");
        } else {
            System.out.println("없는 구매번호 입니다.");
        }
    }

    public static void changeMyBuyQuantity(TblBuyDao buyDao) {
        System.out.print("\n구매수량을 변경할 항목의 buy_idx 입력 >> ");
        int buyidx = Integer.parseInt(System.console().readLine());
        System.out.print("변경할 구매수량 입력 >> ");
        int quan = Integer.parseInt(System.console().readLine());
        if (buyDao.update(buyidx, quan) == 1) {
            System.out.println("정상적으로 수정되었습니다.");
        } else {
            System.out.println("없는 구매번호 입니다.");
        }
    }

}   // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java 
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java  
    //         테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.     
    //         insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.       
