package basic.day5;

import java.util.Arrays;

// 데이터의 참조값과 관련된 테스트
public class A29ArrayVariableTest {
    public static void main(String[] args) {
        int[] iArray = { 1, 2, 3, 4, 5 };
        double[] dArray = new double[5];
        char[] cArray = new char[5];
        cArray[0] = 'j';
        cArray[1] = 'a';
        cArray[2] = 'v';
        cArray[3] = 'a';
        cArray[4] = '!';
        // cArray[4] = ''; // 비어있는 값('')은 오류. 반드시 최소 1글자 필요.

        System.out.println("1.  ");
        System.out.println(iArray);
        System.out.println("2.  ");
        System.out.println(dArray);
        System.out.println("3.  ");
        System.out.println(cArray);

        int[] temp;
        temp = iArray; // iArray의 주소(참조값)을 temp 변수에 저장
        System.out.println("4.  ");
        System.out.println(temp);

        System.out.println("\n5.    참조값을 전달받은 temp 배열 확인");
        temp[3] = 999;
        iArray[4] = 111;
        System.out.println("temp 배열의 값 : " + Arrays.toString(temp));
        System.out.println("iArray 배열의 값 = " + Arrays.toString(iArray));
    }
}
