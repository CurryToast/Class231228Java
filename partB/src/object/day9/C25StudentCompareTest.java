package object.day9;

import java.util.Arrays;
import java.util.Comparator;

// Arrays.sort 메소드에 두번째 인자로 Comparator 인터페이스 타입 객체를 전달하면 비교 기준과 정렬 방법을 실행 시점에서 결정되게 할 수 있습니다.
public class C25StudentCompareTest {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("장모모", 23);
        students[1] = new Student("박나연", 22);
        students[2] = new Student("김다현", 24);
        students[3] = new Student("사나", 21);

        System.out.println("초기 Students 배열 : " + Arrays.toString(students));
        // Arrays.sort(students); // 오류 : Student 객체는 Comparable이 아닙니다.
        // System.out.println("초기 Students 배열 : " + Arrays.toString(students));

        // 나이 오름차순 (람다식)
        Arrays.sort(students, (o1, o2) -> {
            // o1(왼쪽), o2(오른쪽)
            // 오름/내림 상관없이 교환을 안해도 되는 경우를 음수값으로 리턴합니다.
            // sort 메소드 정렬 알고리즘은 비교결과 음수 리턴하면 교환하지 않고, 양수 리턴하면 교환합니다.
            return o1.getAge() - o2.getAge();
        });
        System.out.println("나이 오름차순 정렬 후 Students 배열 : " + Arrays.toString(students));

        // 나이 내림차순
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge() - o1.getAge();
            };
        });
        System.out.println("나이 내림차순 정렬 후 Students 배열 : " + Arrays.toString(students));

        // 이름 오름차순 (람다식)
        Arrays.sort(students, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        System.out.println("이름 오름차순 정렬 후 Students 배열 : " + Arrays.toString(students));

        // 이름 내림차순
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getName().compareTo(o1.getName());
            };
        });
        System.out.println("이름 내림차순 정렬 후 Students 배열 : " + Arrays.toString(students));
    }
}
