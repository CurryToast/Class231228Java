package io.test;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderPersonalTest {
    public static void main(String[] args) throws IOException {
        try (
            FileReader fr = new FileReader("C:\\Users\\Administrator\\Downloads\\note.txt");
        ) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char)ch);
            }
        } catch (IOException e) {
            System.out.println("파일 리더 예외 : " + e.getMessage());
        }
    }
}
