package object.day6;

import java.util.Scanner;

public class B04CartMain {
    public static void main(String[] args) {
        Cart momos_cart = new Cart();
        int cartMax = 5;

        String[] products = {"새우깡", "칠성사이다", "빅토리아", "제주감귤", "나주배", "호빵", "이클립스"};
        int[] prices = {3000, 2500, 9900, 12000, 9800, 6000, 1500};

        momos_cart.setUserid("momo");
        momos_cart.setProductNames(products);
        momos_cart.setPrices(prices);

        Scanner sc = new Scanner(System.in);

        System.out.println("모모님의 장바구니 입니다.");
        System.out.println(String.format("%s\t%s\t\t%3s", "상품 번호", "상품명", "가격"));

        for (int i = 0; i < products.length; i++) {
            System.out.println(String.format("%5d\t%10s\t\t%5d", i + 1, products[i], prices[i]));
        }

        int sel = 0, k = 0;
        int[] select = new int[cartMax];
        System.out.println("\n장바구니\n");
        while ((sel >= 0) && (k < cartMax)) {
            System.out.print(String.format(" (장바구니 %d/%d) 구매할 상품 번호를 입력하세요 (종료: -1) >> ", k, cartMax));
            sel = sc.nextInt();
            if (sel >= (products.length + 1)) {
                System.out.println("존재하지 않는 상품 번호입니다.");
                continue; // 아래에 있는 명령을 실행하지 않고 다시 반복문 시작으로 돌아가기
            }

            select[k] = sel - 1;
            k++;
        }

        momos_cart.total_Money(select);

        if (k == cartMax) {
            System.out.println("\n장바구니를 가득 채워 주셔서 감사합니다!!\n");
        }

        System.out.println(String.format("구매한 상품의 총 가격은 %d원 입니다.", momos_cart.getTotal_Money()));
    }
}
