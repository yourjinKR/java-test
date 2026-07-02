package org.example.test.functional.repeatInput;

import org.example.Console;

public class Main {
    public static void main(String[] args) {
        int age = InputHandler.repeatUntilValid(() -> {
            System.out.print("나이 입력: ");
            String str = Console.readLine();
            return Integer.parseInt(str);
        });

        System.out.println("너의 나이는 " + age + "살이구나!");
    }
}
