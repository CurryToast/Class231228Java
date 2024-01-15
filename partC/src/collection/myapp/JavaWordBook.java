package collection.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// JavaWord 여러개를 저장할 클래스
//              ㄴ 조희 기능에 유리한 Map을 사용
public class JavaWordBook {
    // key: 영어, 중복 불가, 순서 없음
    // value: 영어, 한글, 레벨
    private Map<String, JavaWord> wordBook;

    public JavaWordBook() {
        // key 값인 영어 단어 순으로 정렬하여 접근하기 위해 TreeMap
        this.wordBook = new TreeMap<>();
    }


    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }


    // 단어 추가
    public void addWord(JavaWord word) {
        this.wordBook.put(word.getEnglish(), word);
    }

    // 단어 조회 - (비교) List에서는 for 반복해서 찾기
    public JavaWord searchWord(String english) {
        return this.wordBook.get(english);
    }

    public List<JavaWord> searchWordByLevel(int level) {
        List<JavaWord> newList = new ArrayList<>();
        for (JavaWord word : this.wordBook.values()) {
            if (word.getLevel() == level) {
                newList.add(word);
            }
        }

        return newList;
    }

    // 단어 삭제 - (비교) List에서는 for 반복해서 찾은 후 인덱스로 삭제
    public void removeWord(String english) {
        this.wordBook.remove(english);
    }

    // (인스턴스 메소드) 전체 단어 출력하기
    public void wordAllPrint() {
        System.out.println("~".repeat(20) + "~ 단어장 ~" + "~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %s", "<English>", "<Korean>", "<Level>"));

        for (JavaWord word : this.wordBook.values()) { // list가 null이면 단어장 전체 출력, 아니면 list 전체 출력
            System.out.println(String.format("%-15s %-15s\t %d", word.getEnglish(), word.getKorean(), word.getLevel()));
        }
    }

    // (스태틱 메소드) 전달받은 단어 리스트를 출력하기
    public static void wordAllPrint(List<JavaWord> list) {
        System.out.println("~".repeat(20) + "~ 단어장 ~" + "~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %s", "<English>", "<Korean>", "<Level>"));

        for (JavaWord word : list) { // list가 null이면 단어장 전체 출력, 아니면 list 전체 출력
            System.out.println(String.format("%-15s %-15s\t %d", word.getEnglish(), word.getKorean(), word.getLevel()));
        }
    }
}
