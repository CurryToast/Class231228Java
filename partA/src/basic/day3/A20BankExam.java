package basic.day3;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        // DecimalFormat df = new DecimalFormat("#,###원"); // 사용할때 : df.format(money)

        int money = 0;

        while (run) {
            int balance = 0; // 잔고가 마이너스가 될 경우에 사용하는 변수

            System.out.println("-----------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔액 | 4. 종료");
            System.out.println("-----------------------------");

            System.out.print("메뉴 선택 >>> ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("예금액 > ");
                    money += sc.nextInt();
                    System.out.println(String.format("고객님의 잔액은 %,d원입니다.", money));
                    break;
                case 2:
                    System.out.print("출금액 > ");
                    balance = money - sc.nextInt();
                    if (balance > 0) {
                        money = balance;
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    System.out.println(String.format("고객님의 잔액은 %,d원입니다.", money));
                    break;
                case 3:
                    System.out.println(String.format("현재 잔고 : %,d원", money));
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 선택 입니다.");
                    break;
            }
        }

    }
}
