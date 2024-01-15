package collection.day12;

import collection.myapp.JavaWord;

/*
 * 객체 지향 프로그래밍은 최대한 객체로 분리시켜서 실행되는 환경에 독립적이 되도록 합니다.
 */

// JavaWordList 객체를 이용해서 수정해보세요.
public class JavaWordAppV3 {
    private JavaWordList words = new JavaWordList();

    public static void main(String[] args) {
        JavaWordAppV3 app = new JavaWordAppV3();
        app.start();
    }

    // 프로그램 실행을 시작하는 메소드
    private void start() {
        // initialize(); // 목록 초기화

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
            int select = 0;
            try {
                select = Integer.parseInt(System.console().readLine()); // 키보드 입력 문자열을 정수로 변환
            } catch (NumberFormatException e) {
            }

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
                    searchWordsByField(); // 단어 검색
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


    // 단어를 추가해주는 메소드
    private void addWord() {
        System.out.println("\n:: 단어 등록 ::");
        System.out.print("영어 단어 입력하세요. _");
        String english = System.console().readLine();

        if (words.searchAllByEnglish(english).size() > 0) {
            JavaWordList.print(words.searchAllByEnglish(english));
            System.out.print("이미 있는 단어입니다. 정말 추가하시겠습니까? (yes)");
            String add = System.console().readLine();
            if (!add.equals("yes")) {
                return;
            }
        }

        System.out.print("한글 단어 입력하세요. _");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요.(1:초급, 2:중급, 3:고급) _");
        int level = 0;

        try {
            level = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            System.out.println("없는 레벨입니다.");
            return;
        }

        words.add(new JavaWord(english, korean, level));
        words.print();
    }

    // 모든 단어 목록을 출력해주는 메소드
    private void wordList() {
        // 리스트 words에 저장된 요소들을 모두 출력
        System.out.println(":: 단어 목록을 출력합니다 ::");
        words.print();
    }

    // 입력받은 단어를 목록에서 검색하는 메소드
    private void searchWordsByString() {
        System.out.print("검색할 단어를 입력하세요. _");
        String find = System.console().readLine();
        JavaWordList.print(words.searchAllByEnglish(find));
    }

    // 입력받은 레벨을 기준으로 단어를 검색하는 메소드
    private void searchWordsByLevel() {
        System.out.print("검색할 레벨을 입력하세요. _");
        int level = Integer.parseInt(System.console().readLine());
        JavaWordList.print(words.searchAllByLevel(level));
    }

    // 검색 메소드
    // 단어 검색 : 문자열을 입력받아 그 문자열과 같은 단어 출력
    // 레벨 검색 : 정수를 입력받아 그 정수와 동일한 레벨의 단어 출력
    private void searchWordsByField() {
        System.out.println(":: 단어 검색 ::");
        System.out.print("메뉴 입력 (1. 단어 검색, 2. 레벨 검색) >>> ");
        int menu = 0;

        try {
            menu = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
        }

        switch (menu) {
            case 1:
                searchWordsByString();
                break;
            case 2:
                searchWordsByLevel();
                break;
            default:
                System.out.println("없는 메뉴입니다!");
                break;
        }
    }

    // 단어 삭제하는 메소드
    private void removeWord() {
        System.out.print("삭제할 단어를 입력하세요 >>> ");
        String keyword = System.console().readLine();
        int position = words.indexOfWord(keyword, 0);

        while (position != -1) {
            System.out.println(String.format("%s", "-".repeat(50)));
            System.out.println(String.format("%-10s \t%-6s \t%6d", words.getWord(position).getEnglish(), words.getWord(position).getKorean(), words.getWord(position).getLevel()));
            System.out.println(String.format("%s", "-".repeat(50)));

            System.out.print("\"" + keyword + "\"를 정말 삭제하겠습니까? (yes) ");
            String remover = System.console().readLine();
            if (remover.equals("yes")) {
                words.remove(position);
                position--;
            }

            position = words.indexOfWord(keyword, ++position); // 찾은 단어 다음 위치부터 다시 찾기
        }
    }

}
