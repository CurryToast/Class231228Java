package basic.day2;

public class A11StringMethod {
    public static void main(String[] args) {
        String message = "Hello, World~";
        System.out.println("message : '" + message + "'");

        // 1. 인자 0개 => length, isEmpty, toUpperCase, toLowerCase, trim ...
        System.out.println("message.length() : " + message.length());
        System.out.println("message.toUpperCase() : " + message.toUpperCase());
        System.out.println("message.toLowerCase() : " + message.toLowerCase());
        System.out.println("message.isEmpty() : " + message.isEmpty());
        // 2. 인자 1개 => indexOf, concat, equlas, charAt, startsWith, endsWith, ...
        System.out.println("message.indexOf(\"World\") : " + message.indexOf("World"));
        System.out.println("message.indexOf(\"world\") : " + message.indexOf("world"));
        System.out.println("message.concat(\" Good Bye\") : " + message.concat(" Good Bye"));
        System.out.println("message.equals(message) : " + message.equals(message));
        System.out.println("message.charAt(0) : " + message.charAt(0)); // 문자열은 0부터 순서대로 문자에게 번호를 매깁니다.
        System.out.println("message.startsWith(\"Hell\") : " + message.startsWith("Hell"));
        System.out.println("message.startsWith(\"hell\") : " + message.startsWith("hell"));
        System.out.println("message.endsWith(\"~\") : " + message.endsWith("~"));
        // 3. 인자 2개 => substring, replace...
        System.out.println("message.substring(5) : " + message.substring(5));
        System.out.println("message.substring(0, 4) : " + message.substring(0, 4)); // endIndex의 문자열은 포함 안함
        System.out.println("message.substring(2, 8) : " + message.substring(2, 8)); // endIndex의 문자열은 포함 안함
        System.out.println("message.replace(\"World\", \"Java\") : " + message.replace("World", "Java"));
        System.out.println("message.replace(\"ll\", \"***\") : " + message.replace("ll", "***"));

        // 리턴 값 기준으로 정리
        // boolean => isEmpty, equals, startsWith, endsWith, isBlank
        // int => length, indexOf
        // char => charAt
        // string => toUpperCase, toLowerCase, trim, concat, substring, replace
    }
}
