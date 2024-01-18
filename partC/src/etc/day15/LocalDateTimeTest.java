package etc.day15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println("1. 현재 날짜와 시간을 구하여 출력하기");
        
        LocalDate currentDate = LocalDate.now(); // 객체 생성 메소드 now(). new 연산을 대신함.
        System.out.println("\t LocalDate 현재 날짜 : " + currentDate);

        LocalTime currentTime = LocalTime.now(); // 10억분의 1초 (ns) 까지 구해줍니다.
        System.out.println("\t LocalTime 현재 시간 : " + currentTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("\t LocalDateTime 현재 날짜와 시간 : " + currentDateTime);

        System.out.println("\n2. 특정 날짜와 시간을 지정해서 객체를 생성합니다.");

        // of 메소드 : 객체를 생성하고 값을 초기화합니다.
        LocalDate mybirth = LocalDate.of(1995, 7, 12);
        LocalTime mybirthTime = LocalTime.of(17, 20);
        LocalDateTime mybirthDateTime = LocalDateTime.of(1995, 7, 12, 17, 20);
        System.out.println("\t LocalDate.of(1995, 7, 12) : " + mybirth);
        System.out.println("\t LocalTime.of(17, 20) : " + mybirthTime);
        System.out.println("\t LocalDateTime.of(2000, 10, 11, 17, 20) :" + mybirthDateTime);

        System.out.println("\n3. 날짜 사이의 간격 계산하기");
        Period between = Period.between(mybirth, currentDate);
        System.out.println(String.format("\t 내가 태어난지 %d년 %d월 %d일이 지났습니다.", between.getYears(), between.getMonths(), between.getDays()));

        System.out.println("\n4. 날짜 사이의 간격 계산하기 (단위: 년 또는 월 또는 일) ");
        System.out.println(String.format("\t 내가 태어나서 %d일이 지났습니다.", ChronoUnit.DAYS.between(mybirth, currentDate)));
        System.out.println(String.format("\t 내가 태어나서 %d월이 지났습니다.", ChronoUnit.MONTHS.between(mybirth, currentDate)));
        System.out.println(String.format("\t 내가 태어나서 %d년이 지났습니다.", ChronoUnit.YEARS.between(mybirth, currentDate)));

        System.out.println("\n5. 내 생일로부터 10000일이 이후 날짜는?");
        LocalDate plusDays = mybirth.plusDays(10000);
        System.out.println("\t 10000일 이후 : " + plusDays);

        System.out.println("\n6. 오늘 날짜로 부터 10000일 이전 날짜는? ");
        LocalDate minusDays = currentDate.minusDays(10000);
        System.out.println("\t 10000일 이전 : " + minusDays);

        System.out.println("\n7. 계산 검증 테스트 - 3일 이전/이후");
        System.out.println("\t 3일 전 : " + currentDate.minusDays(3));
        System.out.println("\t 3일 후 : " + currentDate.plusDays(3));

        System.out.println("\n8. 날짜의 출력 패턴 설정하기");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 DD일");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy년 MM월 DD일 hh시 mm분 ss초");
        System.out.println("\t " + currentDate.format(formatter));
        System.out.println("\t " + currentDateTime.format(formatter2));

    }
}
