package etc.day15;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * InnerMyCalendar
 */

// public 클래스는 한 파일에 1개만 있어야 합니다.
public class InstanceTest {
    // main 메소드는 한 파일에 1개만 있어야 합니다.
    public static void main(String[] args) {
        MyCalendar my = MyCalendar.getInstance();
        // MyCalendar my2 = new MyCalendar();
        // MyCalendar my3 = MyCalendar.object;

        YourCalendar your = YourCalendar.of("12", "25");
        Member member = new Member(null, 0, 0);
        member.getName();
        member.setPoint(0);
        member.hashCode();
        member.toString();
    }
    
}

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Member {
    private String name;
    private int age;
    private int point;

    // lombok.jar 라이브러리 : 매번 작성되는 아래 메소드들을 자동으로 만들어줍니다.
    // 기본생성자와 커스텀생성자
    // getter, setter
    // toString 재정의
    // equals, hashCode 재정의
}


// 클래스는 한 파일에 여러 개 만들 수 있습니다.
class MyCalendar {
    // 필드가 현재 클래스의 타입. 미리 생성자로 객체를 만듭니다.
    private static MyCalendar object = new MyCalendar();

    // 생성자가 private => 다른 클래스에서 사용 못합니다.
    private MyCalendar() {
    }

    public static MyCalendar getInstance(){
        return object;
    }

}

class YourCalendar {
    private String month;
    private String day;

    private YourCalendar() {}

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public static YourCalendar of(String month, String day) {
        YourCalendar result = new YourCalendar();
        result.month = month;
        result.day = day;

        return result;
    }
}