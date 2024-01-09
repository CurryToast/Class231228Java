package object.day8_interface;

import object.day8_interface.beable.AI;
import object.day8_interface.beable.BeAble;
import object.day8_interface.beable.Cookable;
import object.day8_interface.beable.Dog;
import object.day8_interface.beable.Human;
import object.day8_interface.beable.Runnable;
import object.day8_interface.beable.Thinkable;

public class B19BeAbleMain {
    public static void main(String[] args) {
        Thinkable th1 = new AI();
        ((AI)th1).setOp('*');
        Thinkable th2 = new Human();

        Runnable run1 = new Human();
        Runnable run2 = new Dog();

        Cookable cook = new Human();

        BeAble[] beAbles = new BeAble[5];
        beAbles[0] = th1;
        beAbles[1] = th2;
        beAbles[2] = run1;
        beAbles[3] = run2;
        beAbles[4] = cook;

        System.out.println("BeAble 테스트");
        for (BeAble able : beAbles) {
            System.out.println("\t" + able.beAble() + "\n");

            if (able instanceof Thinkable) {
                System.out.println("계산해 주세요! ");
                System.out.println(able.getClass().getName() + " 이 계산합니다.");
                char op = ((AI)th1) instanceof AI ? ((AI)th1).getOp() : '+';
                System.out.print("연산 : " + op);
                System.out.print("\t정답 : " + ((Thinkable)able).calculate(15, 4));
            } else {
                System.out.println(able.getClass().getName() + "은 계산 못합니다.");
            }

            if (able instanceof Runnable) {
                System.out.println(((Runnable)able).run(20));
            } else {
                System.out.println(able.getClass().getName() + "은 달리지 못합니다.");
            }

            if (able instanceof Cookable) {
                ((Cookable)able).cook("버터");
            } else {
                System.out.println(able.getClass().getName() + "은 요리 못합니다.");
            }

            System.out.println();
        }

        /*
         * 결론 : 업캐스팅과 다운캐스팅은 상속과 같은 방식으로 사용할 수 있습니다.
         * 목적
         *      - 업캐스팅 : 다형성
         *      - 다운캐스팅 : 업캐스팅 타입이 갖는 추상 메소드가 아닌 메소드 실행하기 위함
         */
    }
}
