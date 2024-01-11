package collection.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

/*
 * Map<K, V> : Key값으로 Value를 가져오기
 *              ㄴ Key와 Value는 모든 타입 Object입니다.
 *              ㄴ Key는 중복된 값을 가질 수 없습니다. Key와 Value는 모두 순서가 없습니다.
 *              ㄴ Map에 입력된 순서대로 접근해야 한다면 LinkedHashMap, Key 기준 정렬된 방식으로 접근해야한다면 TreeMap
 *              ㄴ Key는 Set 특성을 가지고 있습니다.
 */

public class C05MapExample {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스");
        map.put("js", "뉴진스");

        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("찾을 값에 대한 key 입력 >>> ");
            String key = sc.nextLine();
            if (key.equals("end")) {
                break;
            }

            System.out.println("찾은 값 : " + map.get(key));
            System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
        }

        System.out.println("\tMap.Keyset = " + map.keySet()); // 맵의 키만 가져와서 Set을 생성
        Iterator<String> mapIterator = map.keySet().iterator();
        int cnt = 0;
        System.out.println("::: Iterator :::");
        while(mapIterator.hasNext()) {
            String temp = mapIterator.next(); // 반복자가 가져온 Key값
            System.out.println(String.format("count=%d , key= %s , value=%s", cnt++, temp, map.get(temp)));
        }

        cnt = 0;
        System.out.println("::: for :::");
        for (String key : map.keySet()) {
            System.out.println(String.format("count=%d , key= %s , value=%s", cnt++, key, map.get(key)));
        }

        System.out.println("\n조회");
        System.out.println("map.values : " + map.values());
        System.out.println("map.containsKey(\"tw\") : " + map.containsKey("tw"));
        System.out.println("map.containsValue(\"에스파\") : " + map.containsValue("에스파"));

        sc.close();
    }   
}
