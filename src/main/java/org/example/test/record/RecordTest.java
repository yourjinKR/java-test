package org.example.test.record;

import java.util.List;

public class RecordTest {
    public static void main(String[] args) {
        Person person = new Person("유어진",26);
        Team team = new Team("홍철없는 홍철 팀", List.of(person));

        System.out.println(team);
    }
}
