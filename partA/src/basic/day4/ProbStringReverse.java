package basic.day4;

// 문자열 "Hello World"를 뒤집기

public class ProbStringReverse {
    public static void main(String[] args) {
        String message = "Hello World";
        char[] messageArray = new char[message.length()];
        // String reverseMessage = "";

        System.out.println("원본 메시지 >> " + message);

        // 1. 배열 마지막 자리부터 순서대로 값 저장
        for(int i = 0; i < message.length(); i++) {
            messageArray[message.length() - 1 - i] = message.charAt(i);
        }

        System.out.print("뒤집은 메시지 >> ");
        System.out.println(messageArray);

        // 2. 배열 따로 사용하지 않고, String.format과 String.concat을 이용해 빈 String 변수에 붙이기
        // for (int i = 0; i < message.length(); i++) {
        //     reverseMessage = reverseMessage.concat(String.format("%s", message.charAt(message.length() - 1 - i)));
        // }

        // System.out.println("뒤집은 메시지 >> " + reverseMessage);
    }
}
