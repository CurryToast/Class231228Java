package object.day9;

import java.util.Arrays;

public class C24MemberCompareTest {
    public static void main(String[] args) {
        // Member 객체를 비교하고 Member 배열 정렬도 할 수 있습니다.
        Member momo = new Member("momomo", 23);
        Member nana = new Member("nanana", 20);

        System.out.println("모모와 나나를 비교(나이)");
        System.out.println("\t모모가 나나보다 나이가 " + + momo.compareTo(nana) + "살 " + (momo.compareTo(nana) > 0 ? "많습니다." : "적습니다."));

        Member dahy = new Member("dahyeon", 21);
        Member sana = new Member("sana", 22);

        Member[] members = new Member[4];
        members[0] = momo;
        members[1] = nana;
        members[2] = dahy;
        members[3] = sana;

        System.out.println("초기 members 배열 : " + Arrays.toString(members));
        Arrays.sort(members); // 배열 요소 Member 객체가 compareTo 메소드가 있으므로 정렬 가능
        System.out.println("정렬 후 members 배열 : " + Arrays.toString(members));
    }
}
