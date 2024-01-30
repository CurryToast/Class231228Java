package jdbc.day1;

public class CartApp {
    public static void main(String[] args) {
        System.out.print("구매할 사용자 간편 로그인");
        System.out.print("\t아이디 입력 >>> ");
        String id = System.console().readLine();

        TblBuyDao dao = new TblBuyDao();

        boolean run = true;
        while (run) {
            System.out.println("[1] 장바구니 담기  [2] 구매 취소  [3] 구매 수량 변경 [4] 종료");
            try {
                int select = Integer.parseInt(System.console().readLine());
                switch (select) {
                    case 1: // buy 테이블에 insert (1행)
                        addItems(dao, id);
                        break;
                    case 2: // delete
                        removeItems(dao, id);
                        break;
                    case 3: // update
                        updateQuantity(dao, id);
                        break;
                    case 4:
                        System.out.println("프로그램 종료");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("없는 메뉴입니다.");
                        break;
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    public static void addItems(TblBuyDao dao, String id) {
        System.out.print("구매할 상품 코드 입력 >> ");
        String pcode = System.console().readLine();
        System.out.print("구매할 수량 입력 >> ");
        int quantity = Integer.parseInt(System.console().readLine());

        BuyVo vo = new BuyVo(id, pcode, quantity);
        dao.add(vo);
    }

    public static void removeItems(TblBuyDao dao, String customId) {
        System.out.println("장바구니 출력");
        for (BuyVo vo : dao.selectedBuyListByCustomId(customId)) {
            System.out.println(vo);
        }

        System.out.print("\n삭제할 항목의 buy_idx 입력 >> ");
        int idx = Integer.parseInt(System.console().readLine());
        dao.remove(idx);
    }

    public static void updateQuantity(TblBuyDao dao, String customId) {
        System.out.println("장바구니 출력");
        for (BuyVo vo : dao.selectedBuyListByCustomId(customId)) {
            System.out.println(vo);
        }

        System.out.print("\n구매수량을 변경할 항목의 buy_idx 입력 >> ");
        int idx = Integer.parseInt(System.console().readLine());
        System.out.print("변경할 구매수량 입력 >> ");
        int quantity = Integer.parseInt(System.console().readLine());
        dao.update(idx, quantity);
    }
}

// tbl_buy 테이블을 대상으로 insert, update, delete 할 수 있는 dao 클래스 TblBuyDao.java 만들기
//         테이블 PK 컬럼은 buy_idx -> update, delete의 조건 컬럼입니다.