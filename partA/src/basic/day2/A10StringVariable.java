package basic.day2;

public class A10StringVariable {
    public static void main(String[] args) {
        // String은 문자열: 문자(' ')의 집합. 문자열 리터럴은 기호 ""를 사용합니다.
        String message = "Welcome~ Java World!!!!";
        System.out.println("메세지 '" + message + "'의 길이 : " + message.length());

        // String으로 선언된 변수는 '객체'입니다.
        // 그래서 메소드를 갖고 필요한 기능을 제공해줍니다.

        // char emo = '😎'; // char는 2바이트, 이모지는 4바이트. 문자형으로 저장 안됨.
        // String emo = "😎"; // 이모지는 문자열로 저장.
        // System.out.println(emo);

        // 자바 String의 중요한 메소드 7가지씩 조사해서 테스트 해보기

        // 1. concat() => 다른 문자열을 끝에 붙여서 반환하는 메소드. 원래 문자열을 수정하지 않음.
        System.out.println("1. concat");
        String newstring = message.concat(" Bye~~~~");
        System.out.println("뒤에 붙일 문자열: ' Bye~~~~'");
        System.out.println(message + " => " + newstring);

        // 2. toUpperCase()
        System.out.println("2. toUpperCase : 문자열의 문자를 전부 대문자로 변경하는 메소드. 원래 문자열을 수정하지 않음.");
        String upString = message.toUpperCase();
        System.out.println(message + " => " + upString);

        // 3. toLowerCase()
        System.out.println("3. toLowerCase : 문자열의 문자를 전부 소문자로 변경하는 메소드. 원래 문자열을 수정하지 않음.");
        String lowString = message.toLowerCase();
        System.out.println(message + " => " + lowString);

        // 4. equals()
        System.out.println("4. equals : 두 문자열이 동일한지 판단하는 메소드. 참/거짓을 반환함.");
        String equalMessage = message;
        System.out.println(message + " == " + equalMessage + " => " + message.equals(equalMessage));
        System.out.println(message + " == " + newstring + " => " + message.equals(newstring));
        System.out.println(message + " == " + upString + " => " + message.equals(upString));

        // 5. equlasIgnoreCase()
        System.out.println("5. equalsIgnoreCase : 두 문자열이 동일한지 판단하는 메소드. 대소문자 구분하지 않음. 참/거짓을 반환함.");
        System.out.println(message + " == " + equalMessage + " => " + message.equalsIgnoreCase(equalMessage));
        System.out.println(message + " == " + newstring + " => " + message.equalsIgnoreCase(newstring));
        System.out.println(message + " == " + upString + " => " + message.equalsIgnoreCase(upString));

        // 6. replace()
        System.out.println("6. replace: 문자열에서 특정 값을 지정한 값으로 변경하는 메소드.");
        String secondMessage = "Hello Java. I'm JavaScript";
        System.out.println("Java => Python");
        System.out.println(secondMessage + " => " + secondMessage.replace("Java", "Python"));

        // 7. replaceFirst()
        System.out.println("7. replaceFirst : 문자열에서 특정 값을 지정한 값으로 변경하는 메소드. 특정 값에 처음으로 해당하는 값만 변경함.");
        System.out.println("Java => Python");
        System.out.println(secondMessage + " => " + secondMessage.replaceFirst("Java", "Python"));
    }
    
}
