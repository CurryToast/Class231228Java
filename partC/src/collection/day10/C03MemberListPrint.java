package collection.day10;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class C03MemberListPrint {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));

        // toString 제정의된 출력이 아닌 직접 출력

        System.out.println("For");
        System.out.println(String.format("%7s   %7s", "이름", "나이"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("%9s   %8d", list.get(i).getName(), list.get(i).getAge()));
        }

        // 컬렉션에서는 반복자(Iterator)로 데이터에 접근합니다.
        System.out.println("\nIterator");
        int count = 0;
        Iterator<Member> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("\t count = " + count++ + ", 요소 = " + iterator.next());
        }

        System.out.println("\nForEach");
        count = 0;
        for (Member member : list) {
            System.out.println("\t count = " + count++ + ", 요소 = " + member.toString());
        }
    }
}
