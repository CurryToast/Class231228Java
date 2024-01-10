package object.day9;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return String.format("Student [이름 : %s, 나이 : %d]", this.name, this.age);
    }
}

/*
 * Member 클래스 compareTo의 문제점
 * 비교 기준, 정렬 방법(오름, 내림)을 변경하려면 클래스 내부의 compareTo 메소드를 직접 변경해야 합니다.
 *      ㄴ Member를 사용하는 기존의 다른 프로그램에 영향
 * 
 */