package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.myapp.JavaWord;

public class D08FileReader {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // readByChar();
        // readByCharArray();
        // readByScanner();
        readByScanner2();

        long end = System.currentTimeMillis();
        System.out.println(String.format("\n소요시간 : %,d ms", (end - start)));
    }


    public static void readByChar(){
        // String filePath = "단어장.txt";
        String filePath = "C:\\Windows\\PFRO.log";
        StringBuilder content = new StringBuilder(); // 문자열 저장하고 변경할 수 있는 가변 객체
        int charValue, count = 0;

        try(FileReader fr = new FileReader(filePath)){
            while ((charValue = fr.read()) != -1) { // 문자 단위 입력
            // System.out.println((char)charValue); // 문자 단위이므로 표준 출력 가능
            content.append((char)charValue); // int 값을 char로 변환하여 StringBuilder에 추가
            count++;
            }   
        } catch (Exception e) { }
        // FileReader 닫기

        // 파일에서 읽은 내용 출력
        System.out.println(content.toString());
        System.out.println("읽은 문자수 : " + count);
    }

    public static void readByCharArray(){
        // String filePath = "단어장.txt";
        String filePath = "C:\\Windows\\PFRO.log";
        StringBuilder content = new StringBuilder();
        char[] charValues = new char[256];
        int count = 0, b, charCount = 0;

       try(FileReader fr = new FileReader(filePath)){
         while ((b = fr.read(charValues,0,256)) != -1) { // read(배열이름, 시작위치, 최대문자길이)
            // System.out.print("읽은 내용 : " + new String(charValues, 0, b)); // String(배열 이름, 시작 위치, 길이) => String 생성자
            // int 값을 char로 변환하여 StringBuilder에 추가.
            content.append(charValues,0,b);
            charCount += b;
            count++;
        }   
    } catch (Exception e) { }
        // FileReader 닫기

        // 파일에서 읽은 내용 출력
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println(content.toString());
        System.out.println("읽은 문자수 : " + charCount);
        System.out.println("반복 횟수 : " + count);
    }

    public static void readByCharBuffer() {
        // String filePath = "단어장.txt";
        String filePath = "C:\\Windows\\PFRO.log";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; // 라인 단위로 읽어서 저장할 변수
            while ((line = br.readLine()) != null) { // 한 줄이 256문자보다 많이 적으면 위의 char 배열보다 시간은 더 소요될 수 있습니다.
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("파일 입력 예외 : " + e.getMessage());
        }
    }

    public static void readByScanner(){
        String filePath = "단어장.txt";
        int count = 0;
        // Scanner 클래스 : 1) 한줄씩 읽는 nextLine 메소드, 2) 구분 기호로 분리해서 읽는 방법 
        try(Scanner fc = new Scanner(new FileReader(filePath))) {
            fc.useDelimiter(",|\\n"); // 구분기호(delimiter) 또는 엔터
            // 파일의 끝까지 반복
            while (fc.hasNext()) {
                String token = fc.next();
                System.out.println(token);
                count++;
            }

        } catch (Exception e) { }

        System.out.println("읽은 단어수 : " + count);
    }

    public static void readByScanner2(){
        String filePath = "단어장.txt";
        List<JavaWord> list = new ArrayList<>();

        try(Scanner fc = new Scanner(new FileReader(filePath))) {
            fc.useDelimiter(",|\\n");

            while (fc.hasNext()) {
                list.add(new JavaWord(fc.next().trim(), fc.next().trim(), Integer.parseInt(fc.next().trim())));
            }

            for(JavaWord word : list) {
                System.out.println(word);
            }

        } catch (Exception e) { }
    }
}
