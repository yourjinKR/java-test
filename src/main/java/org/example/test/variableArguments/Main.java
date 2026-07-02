package org.example.test.variableArguments;

import java.text.MessageFormat;
import java.util.Arrays;

public class Main {
    /*
        아래와 같이 호출될탠데
        func(a, b, c, d);
        이렇게 된다면 어디서부터 어디까지가 가변인자인지 모름
     */
//    public void func(String ...str, int a) {
//    }
    
    // 올바른 예시
    public void fun(String ...strings) {
        
    }

    static public String format(String message, Object ...args) {
        System.out.println(Arrays.toString(args));
        return MessageFormat.format(message, args);
    }

    static public String format2(String message, Object ...args) {
        Object newObj = args;

        return format(message, newObj);
    }

    static public String format3(String message, Object ...args) {
        Object newObj = args;

        return format2(message, newObj);
    }

    public static void main(String[] args) {
        long id = 1;
        String message = "해당 ID와 일치하는 세부 부위를 찾지 못했습니다 ID : {0}";

        System.out.println(format3(message, id));
    }
}
