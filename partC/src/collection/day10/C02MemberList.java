package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C02MemberList {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();

        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));

        // hashCode, equals 메소드 재정의하기 전/후 비교하세요.
        // 컴파일러는 객체의 hashCode가 같으면 equals 검사합니다. 둘다 통과하면 동일객체.
        //                                  ㄴ remove, indexOf 등 메소드에서 동일 객체인지 검사할때 사용

        System.out.println("현재 리스트 내용 : " + list + ", 크기 : " + list.size());
        list.remove(new Member("momo", 23));
        System.out.println("삭제 후 리스트 내용 : " + list + ", 크기 : " + list.size());

        System.out.println("특정 멤버 조회하기 : " + list.indexOf(new Member("sana", 26)));

        // new 연산을 실행할 때마다 필드 값이 같아도 동일한 객체를 생성하지 않습니다.
        // remove, indexOf 등의 메소드는 동일한 객체를 찾아서 삭제하거나 조회합니다.
        // 참고 : String은 문자열 리터럴이 같으면 주소가 같습니다. (불변 객체)
        // 일반적으로 만들어진 클래스는 hashcode로 메모리 참조 위치가 결정됩니다.
        //                              ㄴ 인스턴스 필드 내용이 같으면 hashcode를 동일하게 만들도록 재정의합니다.
    }
}
