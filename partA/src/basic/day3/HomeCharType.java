package basic.day3;

/*
  문자열을 구성하는 문자의 종류 분석하기

  1) 문자열을 임의로 저장합니다. 예시 : "Hello* Java Hi* Linux~~~" 
  2) 1)번의 문자열을 구성하는 문자 하나하나가  '대문자' '소문자' '숫자' '기호' 중 어떤 종류의 문자인지 검사합니다.
  3) 2)번의 검사를 통해서 문자열을 구성하는 문자의 종류와 개수를 구하여 출력합니다.

  변수명
    대문자의 갯수 upperCount
    소문자의 갯수 lowerCount
    숫자의 갯수 numberCount
    기호의 갯수 symbolCount
 */

public class HomeCharType {
    public static void main(String[] args) {
        String message = "Hello Java17.0~ !?";
        int upperCount = 0, lowerCount = 0, numberCount = 0, symbolCount = 0;

        for (int i = 0; i < message.length(); i++) {
            char item = message.charAt(i);

            if (item >= 48 && item <= 57) { // 숫자일때
                numberCount++;
            } else if (item >= 65 && item <= 90) { // 대문자일때
                upperCount++;
            } else if (item >= 97 && item <= 122) { // 소문자일때
                lowerCount++;
            } else {
                symbolCount++;
            }
        }

        System.out.println(String.format("문자열: %s", message));
        System.out.println(String.format("문자 종류: 대문자 %d개, 소문자 %d개, 숫자 %d개, 기호 %d개", upperCount, lowerCount, numberCount, symbolCount));
    }
}
