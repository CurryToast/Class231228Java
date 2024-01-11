package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<>();

        // 인덱스가 0부터 순서대로 추가됨
        strlist.add("트와이스"); // 인덱스 0
        strlist.add("잇지");
        strlist.add("아이브");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스"); // 인덱스 5

        System.out.println("문자열 LIST strlist size : " + strlist.size());
        System.out.println("\n      데이터 추가");
        strlist.add("르세라핌");
        System.out.println("항목 추가 후 리스트 : " + strlist); // ArrayList 클래스의 toString 메소드 실행

        System.out.println("\n      데이터 삭제");
        strlist.remove("원더걸스"); // remove 메소드 오버로딩
        strlist.remove(1); // 메소드 인자 타입이 int와 String 2가지로 동작
        System.out.println("항목 삭제 후 리스트 : " + strlist);

        System.out.println("\n      데이터 변경");
        strlist.add(2, "??????"); // 중간 삽입. 인덱스 2부터 다음 인덱스로 옮기고 인덱스 2에 데이터 추가
        strlist.set(2, "!!!!!!"); // 수정. 인덱스 2의 데이터 변경
        System.out.println("항목 변경 후 리스트 : " + strlist);

        System.out.println("\n      특정 인덱스 위치의 요소 값 가져오기");
        System.out.println(String.format("%d 인덱스의 값 : %s", 0, strlist.get(0)));
        System.out.println(String.format("%d 인덱스의 값 : %s", 3, strlist.get(3)));
        // System.out.println(String.format("%d 인덱스의 값 : %s", 9, strlist.get(9))); // 요소 없음 => 오류

        // addAll
        System.out.println("\naddAll 기능 확인");
        List<String> temp = new ArrayList<>();
        temp.add("투바투");
        temp.add("세븐틴");
        strlist.addAll(temp);
        System.out.println("      strlist : " + strlist);
        System.out.println("        List temp : " + temp);
        System.out.println("        temp 추가 후 strlist : " + strlist);

        List<String> temp2 = new ArrayList<>();
        temp2.add("아이브");
        temp2.add("세븐틴");
        strlist.addAll(3, temp2);
        System.out.println("\n        strlist : " + strlist);
        System.out.println("        List temp : " + temp2);
        System.out.println("        인덱스 3 에 temp 추가 후 strlist : " + strlist);

        System.out.println("\n조회 기능 확인");
        // contains
        System.out.println("\ncontains\n      contains \"!!!\" : " + strlist.contains("!!!")); // false
        System.out.println("\n      contains \"!!!!!!\" : " + strlist.contains("!!!!!!")); // true
        // indexOf
        System.out.println("\nindexOf\n      indexof \"레드벨벳\" : " + strlist.indexOf("레드벨벳"));
        System.out.println("\n      indexof \"아이브\" : " + strlist.indexOf("아이브"));
        // lastIndexOf
        System.out.println("\nlastIndexof\n      lastIndexof \"아이브\" : " + strlist.lastIndexOf("아이브"));
        System.out.println("\n      lastIndexof \"세븐틴\" : " + strlist.lastIndexOf("세븐틴"));
    }
}

/*
 * List 구현 클래스 특징 : 배열처럼 인덱스를 갖습니다.
 *                              ㄴ 인덱스가 있으므로 데이터에 순서가 있음.
 *                              ㄴ 배열과 다르게 삭제, 조작 및 조회 기능이 있음.
 */