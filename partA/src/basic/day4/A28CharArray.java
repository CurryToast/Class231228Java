package basic.day4;

// 문자열은 문자의 집합. 따라서 문자열 구성하는 문자 하나씩 가져와 배열에 저장해봅시다.
public class A28CharArray {
    public static void main(String[] args) {
        String message = "Hello world! 치킨 먹고싶다.";

        // 문자열의 길이만큼 배열의 크기를 정합니다.
        char[] messageArray = new char[message.length()];

        for(int i = 0; i < message.length(); i++) {
            messageArray[i] = message.charAt(i);
        }

        System.out.print("원문 메시지 : ");
        System.out.println(messageArray); // char 배열만의 특성. 배열 이름으로 println하면 문자열처럼 출력.

        messageArray = encodeMessage(messageArray, 7);
        System.out.print("비밀 메시지 : ");
        System.out.println(messageArray);

        messageArray = decodeMessage(messageArray, 7);
        System.out.print("해독 메시지 : ");
        System.out.println(messageArray);
    }

    // 고대 암호 : 비밀 키 사용
    private static char[] encodeMessage(char[] msg, int key) {
        char[] temp = msg;
        for(int i = 0; i < msg.length; i++) {
            temp[i] += key;
        }

        return temp;
    }

    private static char[] decodeMessage(char[] msg, int key) {
        char[] temp = msg;
        for(int i = 0; i < msg.length; i++) {
            temp[i] -= key;
        }

        return temp;
    }
}
