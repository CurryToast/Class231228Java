package io.day14;

import java.awt.FileDialog;
import java.util.HashMap;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

import javax.swing.JFrame;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream is = null;
        DataInputStream dis = null;
        OutputStream os = null;
        DataOutput dos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            System.out.println("[클라이언트 프로그램] : 연결 요청하는 중");
            socket = new Socket();

            // 3초간 중지
            Thread.sleep(3000); // 단위 : ms

            // 서버에 연결 요청
            socket.connect(new InetSocketAddress("192.168.30.23", 5050));
            System.out.println("__연결 성공.");

            // 서버가 보낸 데이터 받기 : 입력 스트림
            is = socket.getInputStream();

            dis = new DataInputStream(is);
            String message = dis.readUTF();
            System.out.println(message);

            // 서버에게 인사말 보내기
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            System.out.print("서버에게 보낼 메세지 >>> ");
            message = System.console().readLine();
            dos.writeUTF("\t현범's 클라이언트 >>> " + message);

            // 서버에 파일 업로드
            // String filePath = "C:\\Users\\Administrator\\Downloads\\ImageImage.jpeg";
            Map<String, String> map = showDialog();
            String filePath = map.get("folder") + map.get("fileName");

            // 파일명 보내기
            dos.writeUTF(map.get("fileName"));

            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);

            int b;
            while ((b=bis.read()) != -1) {
                dos.write(b);
            }

            System.out.println("파일 업로드 완료!");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
                os.close();
                dis.close();
                is.close();
                socket.close();
            } catch (IOException e) {}
        }
    }

    public static Map<String, String> showDialog() {
        // GUI
        // java.awt, java.swing에서 제공합니다.

        JFrame jf = new JFrame();
        // jf.setSize(200, 200);
        jf.setVisible(false);

        FileDialog fd = new FileDialog(jf, "파일 선택", FileDialog.LOAD);
        fd.setVisible(true);

        // System.out.println(String.format("%s%s", fd.getDirectory(), fd.getFile()).replace("\\", "\\\\"));

        Map<String, String> map = new HashMap<>();
        map.put("folder", fd.getDirectory().replace("\\", "\\\\"));
        map.put("fileName", fd.getFile());

        return map;
    }
}
