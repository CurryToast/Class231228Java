package basic.day2;

/*
 *  1. 문자 '나'부터 '냇'까지 while문으로 출력
 *  2. 모두 몇개의 문자가 있는지 갯수 구하기
 *  char start = '나';
 *  int codeNa, codeNet;
 */

public class A09HangulCharTest {
    public static void main(String[] args) {
        char start = '나', end = '낟';
        int codeNa = start, codeNet = end;

        while (start <= end) {
            System.out.print(start++);
        }

        System.out.println("\n" + (char)codeNa + "~" + (char)codeNet + "까지의 문자의 개수: " + (codeNet - codeNa + 1));
    }
}
