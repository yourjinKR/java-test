package org.example.test.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample1 {
    public static void main(String[] args) {
        Map<Team, List<Member>> map = new HashMap<>();
        Team team = new Team("홍철 없는 홍철 팀");
        Member member1 = new Member("유재석");
        Member member2 = new Member("정형돈");

        map.put(team, List.of(member1, member2));

    }
}

class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class A {
    public static final int a = 1;
}

class B extends A {
    public int getA() {
        return a;
    }
}