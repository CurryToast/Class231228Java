package io.day14;

import java.io.IOException;

import collection.myapp.JavaWord;
import io.JavaWord.JavaWordList;

/*
1. 파일장치로 데이터를 저장하는 것은 입력스트림을 사용한다.( O X ) X
2. 데이터 전송 단위에 따라 바이트기반과 문자기반으로 분류된다. ( O X ) O
3. 1) FileReader 클래스의 부모 클래스는 Reader 클래스이다. ( O X ) O (Reader > InputStreamReader > FileReader)
   2) FileReader 클래스는 문자기반으로 InputStream 의 자식 클래스이다. ( O X ) X (InputStreamReader)
   3) BufferWriter 클래스는 단독으로 사용되는 출력스트림으로 라인단위 처리가 가능하다. ( O X ) X (FileWriter와 같이 사용)
4. 바이트 기반의 입력스트림을 처리 속도 향상을 위해 사용할 수 있는 방법은? (2가지) 바이트 단위의 버퍼 배열 사용, 보조 스트림 BufferedInputStream/BufferedOutputStream
5. 입출력스트림의 메소드 대부분이 처리가 필요한 예외는? IOException
6. 예외처리를 강요하는 것은 언체크드 익셉션이다. ( O X ) X (체크드 익셉션) (UnCheckedException, 실행 중 발생하는 RuntimeException의 하위 클래스)
7. 예외처리를 직접 하지 않고 호출한 메소드로 위임하는 키워드는? throws
8. 개발자는 throw 명령으로 조건이 만족되지 않은 경우 예외를 발생시킬 수 있다. ( O X ) O
9. 입출력스트림으로 사용된 객체는 반드시 자원해제를 해야한다. ( O X ) O
10. System.in 표준입력만 사용하여 최대 20바이트의 문자열을 입력받을 수 있는 코드를 작성해보세요.
    입력받은 내용은 출력으로 확인도 합니다. 총 라인수 3~4 줄 (ReviewProb.java)
 */


public class ReviewProb {
    public static void main(String[] args) {
        // prob_8();
        prob_10();
    }

    // 8번
    public static void prob_8() {
        JavaWordList words = new JavaWordList("단어장.txt");
        words.fileLoad();
        try {
            words.add(new JavaWord("null", "비어있는", 1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 개발자가 만드는 예외
        // 1) 예외가 발생되는 문법 오류, 실행 오류 없지만 값의 범위를 제한하기 위해 예외 발생
        // 2) 기본에 발생하는 예외를 새로운 내용으로 변경할 때
    }

    // 10번
    public static void prob_10() {
        byte[] buffer = new byte[20];

        System.out.print("문자열 입력 >>> ");
        try {
            int b = System.in.read(buffer);
            System.out.println("입력 바이트 수 : " + b);
            System.out.println("입력한 문자열 : " + new String(buffer));
            System.out.println("입력한 문자열 정수 변환 : " + Integer.parseInt(new String(buffer).trim()));
        } catch (IOException | NumberFormatException e) {
            System.out.println("예외 : " + e.getMessage());
        }
    }
}
