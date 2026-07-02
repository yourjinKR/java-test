package org.example.test.exceptionTest;

public class ExceptionRethrow {
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println("에러 2번 처리");
        }
    }

    static void method() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("에러 1번 처리");
            throw e;
        }
    }
}
