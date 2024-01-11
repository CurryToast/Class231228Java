package collection.day10;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

// Map 연습

public class C06TodayMenuVote {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Chicken", 0);
        map.put("Spaghetti", 0);
        map.put("Gopchang", 0);
        map.put("Bulgogi", 0);
        map.put("Pork belly", 0);

        System.out.println("오늘의 메뉴 투표합니다.");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("메뉴 : " + map.keySet());
            System.out.print("영문 메뉴 이름 입력 >>> ");
            String key = sc.nextLine();
            if (key.equals("end")) {
                break;
            }
            
            if (!map.keySet().contains(key)) {
                System.out.println("원래 없던 메뉴입니다. 새로 추가합니다.");
                map.put(key, 1);
                continue;
            }

            map.put(key, map.get(key) + 1);
        }

        System.out.println("투표가 종료되었습니다.");
        Comparator<Entry<String, Integer>> comparator = (o1, o2) -> {
            return o1.getValue() - o2.getValue();
        };

        Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), comparator);
        System.out.println("투표 결과");
        System.out.println("\t 메뉴 : " + maxEntry.getKey());
        System.out.println("\t 투표 수 : " + maxEntry.getValue());

        sc.close();
    }
}
