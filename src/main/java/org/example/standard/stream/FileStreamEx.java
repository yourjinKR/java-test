package org.example.standard.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileStreamEx {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String content = "Hello, Java File Stream!";

        // 1. 파일 출력 (파일에 쓰기)
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] bytes = content.getBytes();
            fos.write(bytes);
            System.out.println("파일 씀");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 파일 입력 (파일에서 읽기)
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int data;
            System.out.print("파일 내용 읽기: ");
            while ((data = fis.read()) != -1) { // -1은 파일의 끝(EOF)을 의미
                System.out.print((char) data); // 읽어온 바이트를 문자로 변환하여 출력
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
