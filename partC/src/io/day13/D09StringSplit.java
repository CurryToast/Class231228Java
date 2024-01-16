package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09StringSplit {
    private static String filePath = "score.txt";

    public static void main(String[] args) {
        List<Score> list = makeList(filePath);
        for (Score score : list) {
            System.out.println(String.format("이름: %s, 국어: %d, 영어: %d,  수학: %d", score.getName(), score.getKorean(), score.getEnglish(), score.getMath()));
        }
    }

    public static List<Score> makeList(String filePath) {
        List<Score> lists = new ArrayList<Score>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lists.add(makeScore(line));
            }
        } catch (IOException e) {
            System.out.println("예외 : " + e.getMessage());
        }

        return lists;
    }


    public static void split_test2(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Score stu = makeScore(line);
                System.out.println(String.format("count = %d, score object = %s", count, stu));
                count++;
            }
        } catch (IOException e) {
            System.out.println("예외 : " + e.getMessage());
        }
    }

    public static Score makeScore(String line) {
        String[] temp = line.split(",");
        return new Score(temp[0], Integer.parseInt(temp[1].trim()), Integer.parseInt(temp[2].trim()), Integer.parseInt(temp[3].trim()));
    }


    public static void split_test1() {
        String stu = "김모모,67,77,88";
        String[] temp = stu.split(",");
        System.out.println(Arrays.toString(temp));

        for (String t : temp) {
            System.out.println("배열요소 : " + t);
        }

        System.out.println("2. 분리된 결과로 Score 객체 만들기");

        Score score = new Score(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
        System.out.println("Score 출력 1 : " + score.datas());
        System.out.println("Score 출력 2 : " + score.toString());
    }
}
