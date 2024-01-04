package object.day5;

import java.util.Arrays;

public class Score {
    private String name; // 학생 이름
    private int grade; // 학년
    private int[] jumsues; // 점수들이 저장될 배열. (배열의 크기는 학년마다 다를 수 있음)

    
    // getter
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int[] getJumsues() {
        return Arrays.copyOf(jumsues, jumsues.length);
    }


    // setter
    public void setName(String n) {
        name = n;
    }

    public void setGrade(int g) {
        grade = g;
    }

    public void setJumsues(int[] points) {
        jumsues = Arrays.copyOf(points, points.length);
    }


    // 점수의 합계를 리턴하는 sum() 메소드
    public int sum() {
        int total = 0;
        for(int j : jumsues) {
            total += j;
        }

        return total;
    }


    // 점수의 평균 double을 리턴하는 average() 메소드
    public double average() {
        return (double)sum() / jumsues.length;
    }


    // 모든 인스턴스 필드 값을 확인 출력하는 printScore() 메소드
    public void printScore() {
        System.out.println(String.format("학생 정보\n이름: %s\n학년: %d", name, grade));
        System.out.print("점수: ");
        for(int j : jumsues) {
            System.out.print(j + "\t");
        }
        System.out.println(String.format("\n총점: %d점, 평균: %.2f점\n", sum(), average()));
    }

    // 과목명 배열이 있으면 과목명도 같이 출력
    public void printScore(String[] subjects) {
        System.out.println(String.format("학생 정보\n이름: %s\n학년: %d", name, grade));
        System.out.print("점수: ");
        for(int i = 0; i < jumsues.length; i++) {
            System.out.print(String.format("%s %d  ", subjects[i], jumsues[i]));
        }
        System.out.println(String.format("\n총점: %d점, 평균: %.2f점\n", sum(), average()));
    }
}
