package org.example.test.messageFormat;

import java.text.MessageFormat;

public class MessageFormatTest {
    public static void main(String[] args) {

        String format = MessageFormat.format("안녕 {0} {1}", "data", null);
        System.out.println(format);
    }
}
