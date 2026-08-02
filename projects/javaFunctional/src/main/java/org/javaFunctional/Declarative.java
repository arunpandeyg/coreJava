package org.javaFunctional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.javaFunctional.Imperative.Person.Gender.FEMALE;
import static org.javaFunctional.Imperative.Person.Gender.MALE;

public class Declarative {
    public static void main(String[] args) {
        List<Imperative.Person> people = List.of(
                new Imperative.Person("John", MALE),
                new Imperative.Person("Rake", MALE),
                new Imperative.Person("Dinesh", MALE),
                new Imperative.Person("Hira", MALE),
                new Imperative.Person("Mamta", FEMALE),
                new Imperative.Person("Samta", FEMALE),
                new Imperative.Person("Heama", FEMALE),
                new Imperative.Person("Lata", FEMALE)
        );
        System.out.println("//Imperative approach");
        //Imperative approach
        List<Imperative.Person> females = new ArrayList<>();

        for (Imperative.Person person : people) {
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for(Imperative.Person female : females) {
            System.out.println(female);
        }


        System.out.println("//declarative approach");
        //declarative approach


        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("//declarative approach 2");
        //declarative approach 2

        List<Imperative.Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
                females2 .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Imperative.Person.Gender gender;


        public Person(String name, Imperative.Person.Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @java.lang.Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        enum Gender {
            MALE, FEMALE
        }
    }
}
