package org.example.test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

         /*
         ### read();
         단일 문자 하나를 읽어서 해당 문자의 유니코드(정수) 값을 반환한다.
         그러므로 문자를 받고 String으로 변환하도록 하자.
          */

    }
}
