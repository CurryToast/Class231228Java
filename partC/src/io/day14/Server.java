package io.day14;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트와 서버 각각 실행하는 메소드가 다릅니다.
//          ㄴ 서버와 클라이언트 연결 과정이 다르기 때문.

// 프로그램은 서버가 먼저 실행하고 있어야 합니다.

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        InputStream is = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            // 서버 소켓 생성
            server = new ServerSocket(); // 서버 설정을 위한 소켓

            // 서버 연결 정보 ip, port 설정
            server.bind(new InetSocketAddress("192.168.30.23", 5050));
            System.out.println("[서버 프로그램 시작] : 연결 요청을 기다리는 중");

            // 클라이언트 연결 요청(connect)에 한해 수락
            socket = server.accept(); // 입출력 스트림을 만들 소켓
            System.out.println("__연결을 수락합니다."); // accept 정상 완료되면 실행.

            // 서버가 클라이언트에게 데이터 보내기 : 출력 스트림
            // 클라이언트와 서버가 연결된 소켓으로 출력 스트림 생성
            os = socket.getOutputStream();

            // 정수, 실수, 문자열 보내는 스트림
            dos = new DataOutputStream(os); // 보조 스트림
            dos.writeUTF("\tFrom 현범's 서버 >>> 환영합니다!");

            // 클라이언트가 보낸 인사말 받기
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            String message = dis.readUTF();
            System.out.println(message);

            // 클라이언트가 보낸 파일명 받기
            String filePath = dis.readUTF();
            System.out.println("클라이언트가 업로드한 파일 명 : " + filePath);

            // 클라이언트가 보낸 파일 다운로드
            fos = new FileOutputStream("d:\\" + filePath);
            bos = new BufferedOutputStream(fos);

            int b, count = 0;
            while ((b=dis.read()) != -1) {
                bos.write(b); // 버퍼 스트림 이용한 바이트 단위 출력
                count++;
            }

            System.out.println("파일 다운로드 완료!");
            System.out.println("받은 파일 크기 : " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제. close 처리
            try {
                bos.close();
                fos.close();
                dis.close();
                is.close();
                dos.close();
                os.close();
                socket.close();
                server.close();
            } catch (IOException e) {}
        }
    }
}
