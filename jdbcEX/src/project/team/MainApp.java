package project.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.dao.TblBuyMenuDao;
import project.dao.TblMembersDao;
import project.dao.TblMenuDao;
import project.vo.BuyMenuVo;
import project.vo.MembersVo;
import project.vo.MenuVo;

public class MainApp {
    private TblMembersDao membersDao = new TblMembersDao();
    private TblMenuDao menuDao = new TblMenuDao();
    private TblBuyMenuDao buyMenuDao = new TblBuyMenuDao();
    private List<BuyMenuVo> cart = new ArrayList<BuyMenuVo>();
    private Map<String, Integer> priceMap = new HashMap<>();
    private String customerCode = null;

    public MainApp() {
        this.priceMap = menuDao.getPriceTable();
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.start();
    }

    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[C] 카테고리 별 검색  [P] 상품명 검색");
        System.out.println("[B] 바로 구매하기  [D] 구매 취소  [X] 프로그램 종료");
        System.out.println("::고객정보:: [I] 개인정보 조회  [N] 개인정보 변경  [M] 나의 구매내역");
        System.out.println("::장바구니:: [A] 담기  [L] 목록  [J] 수량 변경  [R] 삭제  [Y] 모두 구매 ");
        System.out.println(".".repeat(70));
    }

    public void start() {
        boot();

        boolean boo = true;
        while (boo) {
            showMenu();
            System.out.print("메뉴 입력 >>> ");
            String menu = System.console().readLine();

            switch (menu) {
                case "C", "c":
                    searchMenuByCategory();
                    break;
                case "P", "p":
                    searchMenuByMname();
                    break;
                case "T","t":
                    break;
                case "B","b":
                    buyMenu();
                    break;
                case "D","d":
                    cancelBuyMenu();
                    break;
                case "I", "i":
                    showMyInfo();
                    break;
                case "N","n":
                    changeMyInfo();
                    break;
                case "M", "m":
                    searchMyBuyList();
                    break;
                case "A","a":
                    addCart();
                    break;
                case "L","l":
                    showCartList();
                    break;
                case "R","r":
                    removeCartList();
                    break;
                case "Y","y":
                    buyAllCartList();
                    break;
                case "X","x":
                    boo = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void boot() {
        System.out.println("::: 사용자 간편 로그인 (1) / 회원가입 (2) :::");
        System.out.print("\t메뉴 선택 >> ");
        int signMenu = Integer.parseInt(System.console().readLine());

        boolean run = true;
        while (run) {
            switch (signMenu) {
                case 1:
                    run = !login();
                    break;
                case 2:
                    join();
                    break;
                default:
                    break;
            }
        }
    }

    public int join() {
        System.out.println("============== 회원 가입 ==============");
        System.out.print("\t회원코드 입력");
        String newCode = System.console().readLine();
        System.out.print("\t회원이름 입력 >>> ");
        String newName = System.console().readLine();
        System.out.print("\t회원이메일 입력 >>> ");
        String newEmail = System.console().readLine();
        System.out.print("\t회원전화번호 입력 >>> ");
        String newPhoneNumber = System.console().readLine();
        System.out.print("\t회원나이 입력 >>> ");
        int newAge = Integer.parseInt(System.console().readLine());

        MembersVo vo = new MembersVo(newCode, newName, newEmail, newPhoneNumber, newAge);

        return membersDao.signup(vo);
    }

    public boolean login() {
        System.out.println("============== 로그인 ==============");
        System.out.print("\t회원코드 입력 >> ");
        this.customerCode = System.console().readLine();

        return membersDao.signin(customerCode);
    }

    public void searchMenuByMname() {
        System.out.println("============== 상품명으로 검색 ==============");
        String mname = System.console().readLine();
        List<MenuVo> list = menuDao.selectMenuByName(mname);
        if (list.size() > 0) {
            for (MenuVo vo : list) {
                System.out.println(vo);
            }
        }
    }

    public void searchMenuByCategory() {
        System.out.println("============== 카테고리 별 검색 검색 ==============");
        System.out.print("\t카테고리 입력 >> ");
        String category = System.console().readLine();
        List<MenuVo> list = menuDao.selectMenuByCategory(category);
        if (list.size() > 0) {
            for (MenuVo vo : list) {
                System.out.println(vo);
            }
        }
    }

    public void searchMyBuyList() {
        System.out.println("============== 구매내역 조회 ==============");
        List<BuyMenuVo> list = buyMenuDao.selectMyBuyList(this.customerCode);
        if (list.size() > 0) {
            for (BuyMenuVo vo : list) {
                System.out.print(vo);
                System.out.println(" 결제 금액 : " + vo.getMenuQuantity() * priceMap.get(vo.getMenuId()));
            }
        }
    }

    public BuyMenuVo addMenu() {
        System.out.print("\t구매할 메뉴코드 입력 >> ");
        String mcode = System.console().readLine();
        System.out.print("\t구매할 수량 입력 >> ");
        int mquantity = Integer.parseInt(System.console().readLine());

        return new BuyMenuVo(customerCode, mcode, mquantity);
    }

    public void buyMenu() {
        System.out.println("============== 바로 구매 ==============");
        buyMenuDao.insert(addMenu());
    }

    public void cancelBuyMenu() {
        System.out.println("============== 바로 취소 ==============");
        System.out.print("\t취소할 구매번호 입력 >> ");
        int buyIndex = Integer.parseInt(System.console().readLine());
        buyMenuDao.delete(buyIndex);
    }

    public void addCart() {
        System.out.println("============== 장바구니 담기 ==============");
        cart.add(addMenu());
    }

    public void showCartList() {
        System.out.println("============== 장바구니 목록 ==============");
        if (cart.size() > 0) {
            int sum = 0;
            for (int i = 0; i < cart.size(); i++) {
                int money = cart.get(i).getMenuQuantity() * priceMap.get(cart.get(i).getMenuId());
                System.out.print("\t장바구니 번호 : " + i + "  " + cart.get(i));
                System.out.println("  금액 : " + money);
                sum += money;
            }

            System.out.println("총 결제 금액 : " + sum);
        } else {
            System.out.println("장바구니에 상품이 없습니다.");
        }
    }

    public void removeCartList() {
        System.out.println("============== 장바구니 삭제 ==============");
        System.out.print("\t삭제할 장바구니 번호 입력 >> ");
        int cartIdx = Integer.parseInt(System.console().readLine());
        if (cartIdx >= 0 && cartIdx < cart.size()) {
            cart.remove(cartIdx);
        } else {
            System.out.println("잘못된 장바구니 번호입니다.");
        }
    }

    public void buyAllCartList() {
        System.out.println("============== 장바구니 전부 구매 ==============");
        if (cart.size() > 0) {
            buyMenuDao.insertMany(cart);
        }
    }

    public void showMyInfo() {
        System.out.println("============== 개인정보 조회 ==============");
        System.out.println(membersDao.selectMyInfo(customerCode));
    }

    public void changeMyInfo() {
        System.out.println("============== 개인정보 변경 ==============");
        System.out.println("입력하지 않은 값은 변경안됨");
        System.out.print("\t변경할 이름 입력 >> ");
        String newName = System.console().readLine();
        System.out.print("\t변경할 이메일 입력 >> ");
        String newEmail = System.console().readLine();
        System.out.print("\t변경할 전화번호 입력 >> ");
        String newPhoneNumber = System.console().readLine();
        MembersVo vo = new MembersVo(customerCode, newName, newEmail, newPhoneNumber);
        if (membersDao.update(vo) > 0) {
            System.out.println("개인정보 변경 완료");
        }
    }
}
