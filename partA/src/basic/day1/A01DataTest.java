package basic.day1;

/* 패키지?
 * 인터넷 주소 https://developers.kakao.com/  와 같은 형식에서  developers.kakao.com 을 도메인네임이라고 하며 , 
 * 자바의 패키지이름은 보통 이것을 com.kakao.developers 와 같이 높은 단계 부터 표시하여 이름을 정한다.
 * 클래스의 소속 그룹을 표시하는 이름이다. Java 객체지향 프로그램은 클래스 단위로 작성됩니다. 개발자가 클래스 이름을 정합니다.
 */

public class A01DataTest {
    public static void main(String[] args) {
        int age = 19;
        double weight = 57.891234567890;
        boolean isAdult;
        char grade = 'C';

        weight -= 1.3;

        age += 7;

        isAdult = age >= 20;

        grade = 'B';
    }
}
