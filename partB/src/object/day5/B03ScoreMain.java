package object.day5;

public class B03ScoreMain {
    public static void main(String[] args) {
        // 학생 4명의 성적을 저장해보세요.
        // 1학년 2명(모모, 다현) 3과목
        // 2학년 2명(나연, 쯔위) 4과목

        String[] subjectOneGrade = {"국어", "수학", "영어"};
        String[] subjectTwoGrade = {"사회", "과학", "음악", "미술"};

        Score momo = new Score();
        Score dahyeon = new Score();
        Score nayeon = new Score();
        Score zz = new Score(); // 쯔위 영문 어떻게 해야될지 모르겠음

        momo.setName("모모");
        momo.setGrade(1);
        momo.setJumsues(new int[]{80, 90, 100});
        momo.printScore(subjectOneGrade);

        dahyeon.setName("다현");
        dahyeon.setGrade(1);
        dahyeon.setJumsues(new int[]{100, 90, 80});
        dahyeon.printScore(subjectOneGrade);

        nayeon.setName("나연");
        nayeon.setGrade(2);
        nayeon.setJumsues(new int[]{70, 80, 90, 100});
        nayeon.printScore(subjectTwoGrade);

        zz.setName("쯔위");
        zz.setGrade(2);
        zz.setJumsues(new int[]{100, 90, 80, 70});
        zz.printScore(subjectTwoGrade);
    }
}
