package basic.day4;

// 문자열 "Hello World"를 뒤집기

public class ProbStringReverse {
    public static void main(String[] args) {
        String message = "Hello World";
        char[] messageArray = new char[message.length()];

        System.out.println("원본 메시지 >> " + message);

        // 배열 마지막 자리부터 순서대로 값 저장
        for(int i = 0; i < message.length(); i++) {
            messageArray[message.length() - 1 - i] = message.charAt(i);
        }

        System.out.print("뒤집은 메시지 >> ");
        System.out.println(messageArray);
    }
}
