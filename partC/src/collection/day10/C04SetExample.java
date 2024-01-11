package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    public static void main(String[] args) {
        // 순서가 없이 무작위로 접근
        Set<String> set1 = new HashSet<>();
        set1.add("트와이스");
        set1.add("아이브");
        set1.add("잇지");
        set1.add("뉴진스");
        set1.add("트와이스");
        set1.add("소녀시대");

        System.out.println("\n\t set1 데이터 요소 한개 씩 접근하기");
        for (String temp : set1) {
            System.out.print(" " + temp);
        }
        System.out.println("\n");

        System.out.println("::::: HashSet :::::");
        System.out.println("set1 : " + set1);
        System.out.println("set1 : " + set1.size());

        // Linked는 다음 입력 데이터의 참조값을 저장하여 입력 순서대로 접근하도록 합니다.
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("트와이스");
        set2.add("소녀시대");

        System.out.println("\n::::: LinkedHashSet :::::");
        System.out.println("set2 : " + set2);
        System.out.println("set2 : " + set2.size());

        // 이진트리 알고리즘을 이요하여 데이터를 정렬된 방식으로 접근합니다.
        Set<String> set3 = new TreeSet<>();
        set3.add("트와이스");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("트와이스");
        set3.add("소녀시대");

        System.out.println("\n::::: TreeSet :::::");
        System.out.println("set3 : " + set3);
        System.out.println("set3 : " + set3.size());
    }
}

/*
 * Set : 집합
 * 순서(인덱스)가 없습니다.
 * 중복값이 없습니다.
 * Map의 구성요소 : Key, Value 중에서 Key는 Set의 특성을 가지고 있습니다.
 */
