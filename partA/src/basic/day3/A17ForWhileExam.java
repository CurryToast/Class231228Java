package basic.day3;

public class A17ForWhileExam {
    public static void main(String[] args) {
        // for가 활용되는 예시
        String message = "Hello, World~ Hoi";

        System.out.println(String.format("문자열: %s\n", message));

        System.out.println("1. (for문) 문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
        for(int i=0; i<message.length(); i++) {
           char temp = message.charAt(i);
           System.out.println(String.format("i=%d, 문자=%c", i, temp));
        }

        System.out.println();

        // 위의 for문을 while문으로 바꿔서 똑같이 실행
        System.out.println("2. (while문) 문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
        int idx = 0;
        while (idx < message.length()) {
            char temp = message.charAt(idx);
            System.out.println(String.format("idx=%d, 문자=%c", idx, temp));
            idx++;
        }

        // 문자열 길이 만큼 반복문 실행하면서 if 조건문으로 문자열 검사하기
        // 문자열에서 알파벳 o인지 아닌지 판단해서 개수 구하기

        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            if (temp == 'o') {
                count++;
            }
        }

        System.out.println(String.format("알파벳 o의 갯수는 %d개.", count));
    }
}
