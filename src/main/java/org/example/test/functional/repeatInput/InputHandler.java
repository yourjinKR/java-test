package org.example.test.functional.repeatInput;

public class InputHandler {

    public static <T> T repeatUntilValid(InputSupplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println("입력 오류: " + e.getMessage());
            }
        }
    }
}