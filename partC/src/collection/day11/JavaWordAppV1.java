package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

public class JavaWordAppV1 {
    // 현재 클래스에서만 사용할 목적으로 접근 제한
    private List<JavaWord> words = new ArrayList<>();

    // 프로그램 실행을 시작하는 메소드
    private void start() {
        initialize(); // 목록 초기화

        // 단어 등록, 목록, 검색, 삭제 기능을 메뉴로 구현합니다.
        System.out.println("단어장 프로그램을 시작합니다.");
        while (true) {
            System.out.println("메뉴를 선택하세요.");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.print("선택 > "); // 메소드에 입력 기능이 있을 때는 Scanner 관리가 불편
            int select = Integer.parseInt(System.console().readLine()); // 키보드 입력 문자열을 정수로 변환

            // System.console() : 시스템의 콘솔(표준 입출력 장치) 객체를 리턴.
            // readLine() : 입력 메소드 실행
            switch (select) {
                case 1:
                    addWord(); // 단어 등록
                    break;
                case 2:
                    wordList(); // 단어 목록 출력
                    break;
                case 3:
                    searchWord(); // 단어 검색
                    break;
                case 4:
                    removeWord(); // 단어 삭제
                    wordList();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("없는 메뉴입니다!");
                    break;
            } // Switch 문 종료

            System.out.println();
        } // While 문 종료
    }


    // 단어 목록을 초기화
    private void initialize() {
        this.words.add(new JavaWord("public", "공용의", 1));
        this.words.add(new JavaWord("private", "개인적인", 1));
        this.words.add(new JavaWord("protected", "보호된", 2));
        this.words.add(new JavaWord("iterator", "반복자", 3));
        this.words.add(new JavaWord("interface", "인터페이스", 2));
    }


    // 단어를 추가해주는 메소드
    private void addWord() {
        System.out.println("\n:: 단어 등록 ::");
        System.out.print("영어 단어 입력하세요. _");
        String english = System.console().readLine();

        if (checkedWord(english).size() > 0) {
            printList(checkedWord(english), null, null);
            System.out.println("이미 있는 단어입니다. 정말 추가하시겠습니까? (yes)");
            String add = System.console().readLine();
            if (!add.equals("yes")) {
                return;
            }
        }

        System.out.print("한글 단어 입력하세요. _");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요.(1:초급, 2:중급, 3:고급) _");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
        printList(words, null, null);
    }

    // 모든 단어 목록을 출력해주는 메소드
    private void wordList() {
        // 리스트 words에 저장된 요소들을 모두 출력
        System.out.print(":: 단어 목록을 출력합니다 ::");
        printList(this.words, null, null);
    }

    // 영어 단어를 확인해서 일치하는 단어만 목록으로 리턴하는 메소드
    private List<JavaWord> checkedWord(String keyword) {
        List<JavaWord> searchedWords = new ArrayList<>();

        for (JavaWord word : this.words) {
            if (word.getEnglish().equals(keyword)) {
                searchedWords.add(word);
            }
        }

        return searchedWords;
    }

    // 입력받은 단어를 목록에서 검색하는 메소드
    private void searchWord() {
        System.out.print(":: 단어 검색 ::\n검색할 단어를 입력하세요. _");
        String find = System.console().readLine();
        List<JavaWord> searchedWords = checkedWord(find);

        printList(searchedWords, String.format("\n검색 결과: %d", searchedWords.size()), "검색결과가 없습니다.");
    }

    // 단어 삭제하는 메소드
    private void removeWord() {
        System.out.print("삭제할 단어를 입력하세요 >>> ");
        String keyword = System.console().readLine();

        System.out.print("\"" + keyword + "\"를 정말 삭제하겠습니까? (yes) ");
        String remover = System.console().readLine();
        if (remover.equals("yes")) {
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).getEnglish().equals(keyword)) {
                    words.remove(i);
                }
            }
        }
    }

    // 단어 목록을 출력해주는 메소드
    private void printList(List<JavaWord> words, String title, String noString) {
        System.out.println(String.format("%s\n%s", (title == null ? "" : title), "-".repeat(50)));

        if (words.size() > 0 ) {
            System.out.println(String.format("%-10s \t%-9s \t%8s", "English", "Korean", "Level"));
            for (JavaWord word : words) {
                System.out.println(String.format("%-10s \t%-6s \t%6d", word.getEnglish(), word.getKorean(), word.getLevel()));
            }
        } else if (noString != null) {
            System.out.println(noString);
        }

        System.out.println(String.format("%s", "-".repeat(50)));
    }


    public static void main(String[] args) {
        // 프로그램 실행하는 객체 생성하고 (메소드로 기능을 분리할때 main이 호출하는 static을 없에기 위함.)
        //                              start 메소드 프로그램 실행 내용을 코딩
        JavaWordAppV1 app = new JavaWordAppV1();
        app.start();
    }
}
