package basic.day1;

public class ProbChangeMoney {
    public static void main(String[] args) {
        int myWon = 1000000; // 여행 경비 (100만원)
        double toYen; // 환전한 엔화 값

        int cost = 98760; // 여행 중 사용한 금액
        int myYen; // 남은 여행 경비
        double toWon; // 남은 경비 환전한 원화 값

        double yenToWonRate = 9.29; // 1엔이 몇 원? 살때
        double wonToYenRate = 8.97; // 1엔이 몇 원? 팔때

        System.out.println("::: 한/일 23.12.28 기준 환율 :::");
        System.out.println("살 때 1엔: " + yenToWonRate + "원");
        System.out.println("팔 때 1엔: " + wonToYenRate + "원\n");

        System.out.println("::: 원화를 엔화로 환전하기 :::");
        System.out.println("환전할 엔화는 " + myWon + "원 입니다.");
        toYen = myWon / yenToWonRate;
        System.out.println("원화를 엔화로 바꿀 때 : " + toYen + "엔 입니다.\n");
        
        System.out.println("::: 엔화를 원화로 환전할 경우 :::");
        System.out.println("일본에서 사용한 금액은 " + cost + "엔 입니다.");
        myYen = (int)(toYen - cost);
        System.out.println("남은 엔화는 얼마인가요? (정수)" + myYen + "엔");
        toWon = myYen * wonToYenRate;
        System.out.println("엔화를 원화로 바꿀 때_: " + toWon + "원\n");
    }
}

/*
 * 복습: 기본 자료형을 크기 순서대로 나열해 봅시다.
 * byte < char < short < int < long < float < double
 *  1      2      2       4      8      4       8 
 * 
 * char 문자형은 코드값 구하기 위해 정수로 캐스팅할 때에는 0~65535를 충분히 저장할 수 있는 int형으로 자동 캐스팅합니다.
*/