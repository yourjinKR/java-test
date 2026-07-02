package org.example.standard.stream.collect;

import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.example.test.record.Person;

public class CollectorsEx {
    public static void main(String[] args) {


        List<Member> members = List.of(
                new Member(1),
                new Member(2),
                new Member(3)
        ) ;

        List<Integer> list = members.stream()
                .map(member -> member.age + 1)
                .toList();

        List<Integer> list2 = members.stream()
                .map(member -> member.age + 2)
                .collect(Collectors.toUnmodifiableList());

        // UnsupportedOperationException
        // list.add(100);
        // list2.add(100);

        List<Integer> list3 = members.stream()
                .map(member -> member.age + 3)
                .collect(Collectors.toList());

        list3.add(100);

        Set<Integer> set = members.stream()
                .map(member -> member.age + 3)
                .collect(Collectors.toSet());

        System.out.println(set);
        set.add(100);

        List<String> example = List.of("apple", "banana", "kiwi", "lemon");

        Map<Integer, String> collect = example.stream().collect(Collectors.toMap(
                String::length,
                Function.identity(),
                (oldValue, newValue) -> oldValue, // 키 충돌시 해결 방법,
                LinkedHashMap::new // Map 타입 이외에 특정 컬렉션으로 저장
        ));

        System.out.println(collect);

        List<String> names = List.of("어진1", "어진2", "어진3");
        String joining = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joining);

        String joining2 = String.join(", ", names);
        System.out.println(joining2);

        List<Person> people = List.of(
                new Person("어진1", 26),
                new Person("어진2", 27),
                new Person("어진3", 28)
        );

        String joining3 = people.stream()
                .map(Person::name)
                .collect(Collectors.joining(", "));

        System.out.println(joining3);

        // 통계 컬렉터
        Double average = people.stream()
                .collect(Collectors.averagingInt(Person::age));
        System.out.println(average);
        // 평균 : averagingInt / averagingLong / averagingDouble
        // 합계 : summingInt / summingLong / summingDouble
        // 최대 / 최소 : maxBy / minBy

        // 통계 요약
        IntSummaryStatistics summaryStatistics = people.stream()
                .collect(Collectors.summarizingInt(Person::age));
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());


        List<Person> groupingList = List.of(
                new Person("어진1", 26),
                new Person("어진2", 27),
                new Person("어진3", 28),
                new Person("어진4", 28)
        );

        Map<Integer, List<Person>> groupedMap = groupingList.stream()
                .collect(Collectors.groupingBy(Person::age));

        System.out.println("groupedMap = " + groupedMap);

        Map<Integer, Set<String>> groupedMapOnlyName = groupingList.stream()
                .collect(Collectors.groupingBy(
                        Person::age,
                        Collectors.mapping(Person::name, Collectors.toSet())
                ));

        System.out.println("groupedMapOnlyName = " + groupedMapOnlyName);

        Map<Integer, List<Person>> groupedAndFilteredMap = groupingList.stream()
                .collect(Collectors.groupingBy(
                        Person::age,
                        Collectors.filtering(
                                person -> person.age() > 26, Collectors.toList()
                        )
                ));

        System.out.println(groupedAndFilteredMap);

        Map<Integer, List<Person>> groupedAndFilteredMap2 = groupingList.stream()
                .filter(person -> person.age() > 26)
                .collect(Collectors.groupingBy(Person::age));

        System.out.println(groupedAndFilteredMap2);

    }
}

class Member implements Comparable<Member> {

    int age;

    public Member(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Member o) {
        return this.age - o.age; // 나이 오름차순
    }

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                '}';
    }
}
