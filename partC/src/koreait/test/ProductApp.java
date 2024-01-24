// 작성자 : 임현범

package koreait.test;

public class ProductApp {
    public static void main(String[] args) {
        // 1번
        Product[] cart = new Product[10];
        cart[0] = new Bike("MTB", 123000, 25);
        cart[1] = new Electronics("USB", 35000);
        cart[3] = new Bike("삼천리", 99000, 15);
        cart[5] = new Electronics("스마트TV", 527000);
        cart[7] = new Electronics("lg냉장고", 2250000);

        // 2번
        ((Electronics)cart[5]).setKwh(0.9);
        System.out.println(String.format("cart[5].power = %f\n", ((Electronics)cart[5]).getKwh()));

        // 3번
        System.out.println("가격이 10만원 이상인 상품만 출력");
        for (Product item : cart) {
            if (item == null) {
                continue;
            }

            if (item.getPrice() >= 100000) {
                System.out.println(item.toString());
            }
        }

        // 4번
        System.out.println("\nBike 객체만 ride 실행");
        for (Product item : cart) {
            if (item == null) {
                continue;
            }

            if (item instanceof Bike) {
                System.out.println(((Bike)item).ride());
            }
        }

        // 5번
        System.out.println("\ncart[3].sell(20) : " + cart[3].sell(20));

        // 6번
        System.out.println("\ncart[5].sell(\"사운드바\") : " + cart[5].sell("사운드바"));
    }
}
