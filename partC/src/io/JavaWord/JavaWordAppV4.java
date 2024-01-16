package io.JavaWord;

import collection.myapp.JavaWord;

public class JavaWordAppV4 {
    private JavaWordList words = new JavaWordList("단어장.txt");

    public static void main(String[] args) {
        JavaWordAppV4 app = new JavaWordAppV4();
        app.start();
    }

    private void start() {
        words.fileLoad(); // 파일에서 단어장 읽어오기

        System.out.println("단어장 프로그램을 시작합니다.");
        while (true) {
            System.out.println("메뉴를 선택하세요.");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.print("선택 > ");
            int select = 0;

            try {
                select = Integer.parseInt(System.console().readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력하세요");
                continue;
            }

            switch (select) {
                case 1:
                    addWord();
                    break;
                case 2:
                    wordList();
                    break;
                case 3:
                    searchWordsByField();
                    break;
                case 4:
                    removeWord();
                    wordList();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    words.fileSave();
                    System.exit(0);
                    break;
                default:
                    System.out.println("없는 메뉴입니다!");
                    break;
            }

            System.out.println();
        }
    }


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
            level = Integer.parseInt(System.console().readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력하세요.");
            return;
        }

        words.add(new JavaWord(english, korean, level));
        words.print();
    }

    private void wordList() {
        // 리스트 words에 저장된 요소들을 모두 출력
        System.out.println(":: 단어 목록을 출력합니다 ::");
        words.print();
    }

    private void searchWordsByString() {
        System.out.print("검색할 단어를 입력하세요. _");
        String find = System.console().readLine();
        JavaWordList.print(words.searchAllByEnglish(find));
    }

    private void searchWordsByLevel() {
        System.out.print("검색할 레벨을 입력하세요. _");
        int level = Integer.parseInt(System.console().readLine().trim());
        JavaWordList.print(words.searchAllByLevel(level));
    }

    private void searchWordsByField() {
        System.out.println(":: 단어 검색 ::");
        System.out.print("메뉴 입력 (1. 단어 검색, 2. 레벨 검색) >>> ");
        int menu = 0;

        try {
            menu = Integer.parseInt(System.console().readLine().trim());
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

            position = words.indexOfWord(keyword, ++position);
        }
    }

}
