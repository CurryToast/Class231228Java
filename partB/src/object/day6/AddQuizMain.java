package object.day6;

import java.util.Scanner;

public class AddQuizMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddQuiz[] quiz = new AddQuiz[3];
        System.out.println(String.format("덧셈 %d문제 퀴즈를 시작합니다.", quiz.length));

        for (int i = 0; i < quiz.length; i++) {
            quiz[i] = new AddQuiz();
            System.out.println(String.format("%d번. %d+%d= ?", (i + 1), quiz[i].getData1(), quiz[i].getData2()));
            System.out.print("답 입력하세요. >>> ");
            quiz[i].setUserAnswer(sc.nextInt());
        }
        System.out.println("::::: 채점 하고 있습니다. :::::");
        System.out.println(String.format("\t%s \t\t%s \t%s \t%s", "문제", "제출한 답", "정답", "채점"));
        for(int i = 0; i < quiz.length; i++) {
            char check = quiz[i].isRight() ? 'O' : 'X';
            System.out.println(String.format("%d번. \t%d+%d \t\t%6d \t\t %3d   %2c", (i + 1), quiz[i].getData1(), quiz[i].getData2(), quiz[i].getUserAnswer(), (quiz[i].getData1() + quiz[i].getData2()), check));
        }
    }
}
