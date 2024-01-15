package collection.myapp;

// 단어장 시작 프로그램
public class JavaWordAppV1 {
    public static void main(String[] args) {
        String menu;

        // 1. 단어장 생성
        JavaWordBook myBook = new JavaWordBook();

        // 2. 단어 추가
        myBook.addWord(new JavaWord("public", "공용의", 1));
        myBook.addWord(new JavaWord("private", "개인적인", 1));
        myBook.addWord(new JavaWord("protected", "보호된", 1));
        myBook.addWord(new JavaWord("iterator", "반복자", 3));
        myBook.addWord(new JavaWord("interface", "인터페이스", 2));
        myBook.addWord(new JavaWord("collection", "수집", 2));
        myBook.addWord(new JavaWord("binary", "2진수의", 3));

        while (true) {
            System.out.println("1. 단어장 전체 출력  2. 단어 조회  3. 단어 삭제");
            System.out.print("메뉴 입력 (end 입력하면 종료, end 이외에 문자열 입력하면 에러 발생함) >>> ");
            menu = System.console().readLine();
            if (menu.equals("end")) {
                break;
            }

            switch (Integer.parseInt(menu)) {
                case 1:
                    myBook.wordAllPrint();
                    break;
                case 2:
                    String submenu;
                    System.out.print("word or level >>> ");
                    submenu = System.console().readLine();
                    if (submenu.equals("word")) { // 영어단어 검색
                        String keyword;
                        System.out.print("검색할 단어 입력 (end 입력 시 종료) >>> ");
                        keyword = System.console().readLine();
                        System.out.println(keyword + " 검색 결과 : " + myBook.searchWord(keyword));
                    } else if (submenu.equals("level")) { // 레벨 기준 검색
                        int level;
                        System.out.print("검색할 레벨 입력 >>> ");
                        level = Integer.parseInt(System.console().readLine());
                        JavaWordBook.wordAllPrint(myBook.searchWordByLevel(level));
                    } else {
                        System.out.println("없는 메뉴 입니다.");
                    }
                    break;
                case 3:
                    String remover;
                    System.out.print("삭제할 단어을 입력하시오 >>> ");
                    remover = System.console().readLine();
                    myBook.removeWord(remover);
                    myBook.wordAllPrint();
                    break;
                default:
                    System.out.println("없는 메뉴 입니다!");
                    break;
            }
        }
    }
}
