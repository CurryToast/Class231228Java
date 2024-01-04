package basic.day5;

public class A30HashCodeTest {
    public static void main(String[] args) {
        int[] iArray = new int[10];
        String message = "Hello~ World~~";

        // hashcode는 참조값(식별값)을 만들기 위해 해시함수로 생성된 결과입니다.
        System.out.println(iArray); // 배열의 식별값을 보여줍니다 (16진수 8자리)
        System.out.println("초기 해시코드 값 : " + iArray.hashCode()); // 배열의 해시코드 값을 가져옵니다.
        System.out.println(Integer.toHexString(iArray.hashCode())); // 10진수를 16진수로 변환

        iArray[3] = 99;
        System.out.println("배열 요소 값 변경 후 해시코드 값 : " + iArray.hashCode()); // 배열 값이 변경되어도 메모리 주소는 동일합니다.

        System.out.println("\nString 배열 message의 초기 해시코드 값 : " + message.hashCode());
        message += "~Good";
        System.out.println("String 배열 message의 값 변경 후 해시코드 값 : " + message.hashCode()); // String은 값이 변경되면 메모리 주소도 달라집니다.
    }
}

/*
 * 객체란? 여러 종류의 데이터가 모여있는 데이터 덩어리. (기본형은 데이터의 최소단위)
 * 객체는 참조형 변수를 사용합니다. (변수가 주소를 저장)
 * 객체를 메모리에 저장 ---> 초기 데이터 변경 가능 (배열) - 가변 객체
 *                     ---> 초기 데이터 변경 불가능 (String) - 불변 객체
 */