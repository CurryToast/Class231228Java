package io.JavaWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

public class JavaWordList implements WordList {
    private List<JavaWord> words;
    private String filePath;

    public JavaWordList(String filePath) {
        System.out.println("최대 단어 저장 개수 : " + WordList.MAX_LENGTH);
        words = new ArrayList<>();
        this.filePath = filePath;
    }


    public void fileLoad() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            while ((line = br.readLine()) != null) {
                if (line.trim().length() <= 0) {
                    break;
                }
    
                String[] temp = line.trim().split(",");
                words.add(new JavaWord(temp[0].trim(), temp[1].trim(), Integer.parseInt(temp[2].trim())));
            }
        } catch (IOException e) {
            System.out.println("파일 내용 읽기 오류 : " + e.getMessage());
        }
    }

    public void fileSave() {
        File wordFile = new File(this.filePath);
        try (PrintWriter bw = new PrintWriter(wordFile);) {
            for(JavaWord word : this.words) {
                bw.println(String.format("%s,%s,%d", word.getEnglish(), word.getKorean(), word.getLevel()));
            }
        } catch (IOException e) {
            System.out.println("파일 내용 저장 오류 : " + e.getMessage());
        }
    }


    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }


    @Override
    public List<JavaWord> list() {
        return words;
    }

    @Override
    public void add(JavaWord word) {
        if (words.size() == WordList.MAX_LENGTH) {
            throw new IllegalArgumentException("단어장이 꽉 찼습니다. 단어장을 새로 만들어 주세요.");
        }

        words.add(word);
    }

    @Override
    public int indexOfWord(String english, int position) {
        for(int i = position; i < words.size(); i++){
            if(words.get(i).getEnglish().equals(english)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public JavaWord remove(int index) {
        if (index < 0 || index > words.size()) {
            //새로운 Exception 객체를 생성하면 개발자가 만든 예외가 발생합니다.
            // 발생시킬 익셉션 종류는 IllegalArgumentException과 같은 이름으로 많이 사용합니다.
            // 예를 들면, 웹개발 할때는 모든 예외를 한번에 처리하기 위해 이런 방법을 사용합니다.
            throw new IllegalArgumentException("삭제할 인덱스 범위가 잘못된 값입니다.");
        }

        JavaWord word = words.remove(index);
        return word;
    }

    public JavaWord searchFirstByEnglish(String english) {
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
                return word;
            }
        }

        return null;            
    }

    @Override
    public List<JavaWord> searchAllByEnglish(String english) {
        List<JavaWord> list = new ArrayList<>();
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);
            }
        }

        return list;
    }

    public List<JavaWord> searchAllByLevel(int level) {
        List<JavaWord> list = new ArrayList<>();    // 검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel() == level) {
               list.add(word); // 일치하는 하는 단어를 만날 때마다 저장
            }
        }

        return list;
    }

    // 인스턴스 메소드 : 인스턴스 필드 words를 사용하여 동작
    @Override
    public void print() {
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

    // 출력 메소드 : 인스턴스 필드 words를 사용하지 않고 동작
    public static void print(List<JavaWord> list) {
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
}