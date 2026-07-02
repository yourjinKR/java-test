package org.example.test.exceptionTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResource {

    public static void main(String args[]) throws IOException {
        try (FileInputStream is = new FileInputStream("file.txt"); BufferedInputStream bis = new BufferedInputStream(is)) {
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        FileInputStream is = null;
//        BufferedInputStream bis = null;
//
//        try {
//            is = new FileInputStream("file.txt");
//            bis = new BufferedInputStream(is);
//            int data = -1;
//            while ((data = bis.read()) != -1) {
//                System.out.println((char) data);
//            }
//
//        } finally {
//            if (is != null) is.close();
//            if (bis != null) bis.close();
//        }
//    }
}


class MyException extends Exception {
    public MyException(String message) {
        super("나만의 에러 메세지");
    }
}
