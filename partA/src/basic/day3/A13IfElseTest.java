package basic.day3;

public class A13IfElseTest {
    public static void main(String[] args) {
        int point = 69;

        if (point >= 70) {
            System.out.println("VIP 회원이십니다. 💕💕"); // chcp 65001 명령어로 터미널에서 인코딩을 UTF-8로 변경해야 이모지 출력됨.
            point += 100;
        } else {
            System.out.println("일반 회원이십니다. 🤞🤞");
            point += 50;
        }

        // 3항연산자 (조건식) ? (참일때 실행) : (거짓일때 실행)
        System.out.println("고객님의 최종 포인트는 " + ((point >= 150) ? (point += 200) : (point += 100)) + "입니다.");
    }
}
