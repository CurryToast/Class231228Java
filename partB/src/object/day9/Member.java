package object.day9;

/*
 * 인터페이스 예시 - 비교 가능한 객체 만들기
 *                      ㄴ 1) Comparable 인터페이스 구현하도록 합시다.
 * Comparable<Member>는 <> 안에 타입을 표시합니다. 이런 방식을 제너릭 타입
 *                      ㄴ 제너릭 타입은 클래스 또는 인터페이스의 메소드에게 타입을 매개변수로 전달하기 위한 방식
 *                          ㄴ 타입이 실행 시점에서 결정되기 때문입니다. 기본형은 Wrapper 클래스로 사용
 *                          ㄴ Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달합니다.
 */

public class Member implements Comparable<Member> {
    private String id;
    private int age;

    public Member(String id, int age) {
        this.id = id;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Member [이름 : " + id + ", 나이 : " + age + "]";
    }


    @Override
    public int compareTo(Member o) { // 메소드의 인자 타입 Member는 <> 제너릭 타입과 같게 만들어집니다.
        // 현재 객체 this를 인자로 전달되는 Member 객체와 비교합니다.
        // 비교 기준은 요구사항에 따라 개발자가 정합니다.

        // 나이 기준
        return this.age - o.age; // 정렬 시 오름차순
        // return o.age - this.age; // 정렬 시 내림차순

        // 이름 기준
        // return this.id.compareTo(o.id); // 정렬 시 오름차순
        // return o.id.compareTo(this.id); // 정렬 시 내림차순
    }
}
