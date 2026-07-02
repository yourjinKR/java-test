package org.example.test.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * value를 List로 사용하고 싶을때
 */
public class MapExample2 {
    public static void main(String[] args) {

        // 일반적 로직
        List<Student> list = List.of(
                new Student(1, "유어진"),
                new Student(1, "유지민"),
                new Student(3, "유재석")
        );

        Map<Integer, List<Student>> school = new HashMap<>();

        List<Student> list1 = list.stream().filter(student -> student.getGrade() == 1).toList();
        List<Student> list3 = list.stream().filter(student -> student.getGrade() == 3).toList();

        school.put(1,list1);
        school.put(2,list3);

        // computeIfAbsent를 활용한 만들기
        Map<Integer, List<Student>> school2 = new HashMap<>();

        List<Student> studentList = List.of(
                new Student(1, "유어진"),
                new Student(1, "유지민"),
                new Student(3, "유재석")
        );

        studentList.forEach(student -> {
            school2.computeIfAbsent(student.getGrade(), key -> new ArrayList<>()).add(student);
        });

        System.out.println(school2);
    }
}

class Student {
    int grade;
    String name;

    public Student(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }
}

