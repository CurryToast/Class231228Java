package object.day9;

import java.util.Arrays;

public class C21ArraySortTest {
    public static void main(String[] args) {
        int[] numbers = {67, 34, 65, 89, 54};
        System.out.println("초기 numbers = " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("정렬 후 numbers = " + Arrays.toString(numbers));

        String[] names = {"momo", "nayeon", "dahyeon", "Zewi", "Beo"};
        System.out.println("초기 names = " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("정렬 후 names = " + Arrays.toString(names));

        // Arrays.sort(배열변수) => 기본형 배열, String 배열의 오름 차순 정렬 가능합니다.
        // -> 내림차순 정렬 또는 다른 참조타입에 대한 정렬은 두번째 인자로 기준 공식을 전달해야 합니다.
        //                                                              ㄴ 인터페이스로 전달합니다.

        // 순차정렬 알고리즘 : 가장 단순한 알고리즘
    }
}
