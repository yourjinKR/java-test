package org.example.standard.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractionEx {
    public static void main(String[] args) {
        Person person1 = new Person(12);
        Person person2 = new Person(13);
        Person person3 = new Person(14);

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);

        Team team = new Team(people);
        List<Person> unModifiedTeam = team.getPeople();

        Person newPerson = new Person(999);

        people.add(newPerson);
        unModifiedTeam.add(newPerson); // UnsupportedOperationException
    }
}

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void getAge(int password) {
        if (password == 2372) {
            System.out.println(age);
        }
    }
}

class Team {
    private final List<Person> people;

    public Team(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }
}
