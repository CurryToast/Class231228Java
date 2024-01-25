package koreait.solution;

public class ProductApp {
    public static void main(String[] args) {
        // 1
        Product[] cart = new Product[10];
        cart[0] = new Bike(1230000, "MTB", 25);
        cart[1] = new Electronics(35000, "USB");
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[5] = new Electronics(527000, "스마트TV");
        cart[7] = new Electronics(2250000, "lg냉장고");

        // 2
        // 다운캐스팅 시 타입체크 합시다.
        if (cart[5] instanceof Electronics) {
            ((Electronics)cart[5]).setKwh(0.9);
            System.out.println(((Electronics)cart[5]).power());
        } else {
            System.out.println("Electronics로 타입 변경 불가");
        }

        // 3
        // 배열 10개중 객체가 참조된 건 5개, 나머지는 NULL => 반복문 실행 중 NULL인지 아닌지 체크 필요.
        for (Product p : cart) {
            if (p != null && p.price >= 100000) {
                System.out.println(p);
            }
        }

        // 4
        for (Product p : cart) {
            if (p != null && p instanceof Bike) {
                System.out.println(((Bike)p).ride());
            }
        }

        // 5
        System.out.println(cart[3].sell(20));

        // 6
        System.out.println(cart[5].sell("사운드바"));
    }
}

/*
 * 자바 교재 204페이지
 * 라이브러리 클래스 : Product, Bike, Electronics, (**제일 중요**)자바 클래스
 *      ㄴ 프로그래밍에 필요한 재료로 사용되는 클래스
 *      ㄴ 인스턴스 메소드, static 메소드로 제공되는 기능을 사용
 * 실행 클래스 : ProductApp
 *      ㄴ main 메소드를 포함하여 프로그램을 실행하는 클래스
 *      ㄴ main 메소드는 반드시 static이어야 함
 *      ㄴ main 메소드를 위한 객체를 먼저 생성할 수 없음
 */