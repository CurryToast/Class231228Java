package object.day6;

public class B06ProductMain {
    public static void main(String[] args) {
        Product snack = new Product("새우깡", 1800, "농심", new String[3]);
        Product drink = new Product("칠성사이다", 2200, "롯데", new String[3]);
        Product fruit = new Product("귤", 7000, "우리농원", new String[3]);
        Product icecream = new Product("투게더", 5000, "빙그레", new String[3]);

        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);

        // 출력 결과 : 패키지이름.클래스이름@객채참조값
        // object.day6.Product@2f92e0f4 
        // object.day6.Product@28a418fc
        // object.day6.Product@5305068a
        // object.day6.Product@1f32e57

        // snack의 etc 필드 배열요소 0번에 "10개 묶음" 문자열을 저장하세요.
        String[] tempString = snack.getEtc();
        tempString[0] = "10개 묶음";

        // Product 객체들 데이터 출력
        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(icecream.getData());

        System.out.println();

        Product[] mycart = new Product[5]; // 객체 배열
        mycart[0] = drink;
        mycart[1] = icecream;
        // mycart[2] = drink;
        mycart[3] = fruit;
        mycart[4] = snack;

        System.out.println("===== My Cart =====");
        for(int i = 0; i < mycart.length; i++) {
            if (mycart[i] != null) {
                System.out.println(mycart[i].getData());
            }
        }
    }
}
