package object.day7;

import java.util.Scanner;

/*
 * 자바 클래스의 생성자로 메소드 오버로딩 알아보기
 *      ㄴ String 클래스
 */

public class B07ConstructorExam {
    public static void main(String[] args) {
        // 문자열 리터럴을 message 변수로 참조
        String message = "Hello~";
        String temp = "Hello~";

        // 문자열 객체 생성하기
        // 1) 메소드 오버로딩 : 메소드 이름이 같으면서 리턴 타입과 인자의 개수와 형식이 다른 정의
        String str1 = new String(); // 생성자 인자 없음
        String str2 = new String("Hello~"); // 생성자 인자 1개. 문자열 리터럴
        String str3 = new String(new char[]{'h', 'e', 'l', 'l', 'o', '~'}); // 생성자 인자 1개. 문자 배열

        System.out.println("new 연산으로 생성된 문자열 출력");
        System.out.println("\tstr1 : " + str1); // 길이가 0인 문자열 객체
        System.out.println("\tstr2 : " + str2);
        System.out.println("\tstr3 : " + str3);

        // 2) 문자열 리터럴의 특징 : 문자열 내용이 같으면 또 메모리에 새로 저장하지 않습니다.
        //                           message가 참조하는 "Hello~"가 동일한 리터럴을 temp가 참조할 때,
        //                           "Hello~"를 또 저장해서 temp가 참조하지 않고 이미 저장되어 있는 "Hello"를 참조
        System.out.println("\nmessage == temp ? " + (message == temp)); // 참조값을 비교
        System.out.println("message == str2 ? " + (message == str2)); // new 연산으로 생성된 객체는 언제나 메모리를 새로 할당
        System.out.println("message == str3 ? " + (message == str3));
        System.out.println("str2 == str3 ? " + (str2 == str3));

        // 3) 문자열 내용 비교 : equals 메소드 사용
        System.out.println("\nmessage.equals(temp) ? " + message.equals(temp));
        System.out.println("message.equals(str2) ? " + message.equals(str2));
        System.out.println("message.equals(str3) ? " + message.equals(str3));
        System.out.println("str2.equals(str3) ? " + str2.equals(str3));


        // 다른 클래스 생성자
        Scanner sc = new Scanner(System.in); // InputStream 클래스로 만들어진 객체 System.in을 생성자 인자로 하여 객체 생성
                                             // System.in은 키보드 입력을 원초적인 방식으로 처리하기 때문에 
                                             // 키보드 입력된 값을 다양한 방식으로 처리할 수 있는 Scanner 클래스 사용

        int num = sc.nextInt(); // 입력 값을 정수 형식으로 변환
        double pi = sc.nextDouble(); // 입력 값을 실수 형식으로 변환
        sc.nextLine(); // 키보드 입력을 저장하는 버퍼에서 실수 입력의 숫자 뒤에 엔터 친 것이 남아 있으므로 처리하기
        String name = sc.nextLine(); // 입력 값을 문자열 형식으로 변환

        System.out.println(num);
        System.out.println(pi);
        System.out.println(name);

        System.out.println("\n위의 입력 테스트에서 nextInt나 nextDouble은 엔터 처리를 안하므로 다음에 나오는 nextLine으로 자동 전달.");
        System.out.println("그래서 nextInt, nextDouble 대신에 다른 방법으로 하기.");

        System.out.print("정수 입력 >>> ");
        temp = sc.nextLine();
        num = Integer.parseInt(temp); // 문자열을 int로 변환하는 메소드 사용
        System.out.print("실수 입력 >>> ");
        temp = sc.nextLine();
        pi = Double.parseDouble(temp); // 문자열을 double로 변환하는 메소드 사용
        System.out.print("문자열 입력 >>> ");
        name = sc.nextLine();
        System.out.println("::::: 입력값 확인 :::::");
        System.out.println(num);
        System.out.println(pi);
        System.out.println(name);

        sc.close();
    }
}
