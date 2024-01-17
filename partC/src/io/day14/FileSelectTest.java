package io.day14;

import java.awt.FileDialog;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class FileSelectTest {
    public static void main(String[] args) {
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
