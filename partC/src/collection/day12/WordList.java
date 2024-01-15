package collection.day12;

import java.util.List;

import collection.myapp.JavaWord;

// 자바 단어장 클래스는 아래의 추상 메소드를 꼭 구현해야 합니다. 

public interface WordList {
    int MAX_LENGTH = 100; // public static final 생략 가능

    JavaWord getWord(int i);
    List<JavaWord> list();
    void add(JavaWord word);
    int indexOfWord(String english, int position);
    JavaWord remove(int index);
    List<JavaWord> searchAllByEnglish(String english);
    void print();

    // 만약에 이미 구현되어 있는 클래스 외에 이후 구현에는 적용하고 싶은 메소드가 있다면
    // default 키워드로 정의
    default List<JavaWord> search(Object object) {
        return null;
    }
}
